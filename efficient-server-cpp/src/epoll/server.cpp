#include <cstdio>
#include <iostream>
#include "server.h"
#include <sys/socket.h>
#include <sys/types.h>

#include <arpa/inet.h>
#include <cerrno>
#include <string>
#include <fcntl.h>
#include <cstring>
#include "../proto/messages.pb.h"

#include "../kdtree.h"
#include <unistd.h>
#include <algorithm>
#include <execution>



void Server::sendResponse(const Response &responseMessage) {
    std::string serializedMessage;
    responseMessage.SerializeToString(&serializedMessage);

    uint32_t responseSize = htonl(serializedMessage.size());
    write(fd, (void *) &responseSize, sizeof(responseSize));

    write(fd, serializedMessage.c_str(), serializedMessage.size());
}
int NOT_FOUND = -1;
void Server::insertWalk(Walk &walk, int64_t src_id, int64_t dst_id) {

    for (int i = 0; i < walk.lengths_size(); i++) {
        Point src = Point(walk.locations(i));
        Point dst = Point(walk.locations(i + 1));

        // TODO: contains
        src_id = dst_id;
        if (src_id == NOT_FOUND)
            src_id = tree.searchProximity(src);
        if (src_id == NOT_FOUND)
            src_id = tree.insert(src);

        dst_id = tree.searchProximity(dst);
        if (dst_id == NOT_FOUND)
            dst_id = tree.insert(dst);

        // Add the destination node ID as a neighbor to the source node with the corresponding walk length
        if (tree.vertices[src_id].nbrs.find(dst_id) != tree.vertices[src_id].nbrs.end()) {
            weight_count &pair = tree.vertices[src_id].nbrs[dst_id];
            pair.first += walk.lengths(i);
            pair.second++;
        } else {
            tree.vertices[src_id].nbrs[dst_id] = {walk.lengths(i), 1};
        }
    }
}

Response Server::getResponse(Request &request) {
    Response response;
    response.set_status(Response_Status_OK);
    response.clear_errmsg();

    switch (request.msg_case()) {
        case Request::kWalk: {
            response.set_total_length(0);
            insertWalk(const_cast<Walk &>(request.walk()), -1, -1);
            response.set_shortest_path_length(0);
            break;
        }
        case Request::kOneToOne: {
            response.set_total_length(0);

            auto oneToOne = request.onetoone();
            int64_t srcId = tree.searchProximity({oneToOne.origin()});
            int64_t dstId = tree.searchProximity({oneToOne.destination()});

            response.set_shortest_path_length(tree.oneToOne(srcId, dstId));
            break;
        }
        case Request::kOneToAll: {
            response.set_shortest_path_length(0);

            auto oneToAll = request.onetoall();
            int64_t srcId = tree.searchProximity({oneToAll.origin()});
            response.set_total_length(tree.oneToAll(srcId));
            break;
        }
        case Request::MSG_NOT_SET:
            printf("OnetoAll request.\n");
            break;
    }

    return response;
}

void Server::handleEvent(int events) {
    if (events > 1) {
        closeConnection();
        return;
    }

    int bytesRead = 0;
    int bytesReceived = 0;

    while (true) {
        if (readData == messageSize && messageSize != 0) {
            readData = 0;
            messageSize = 0;
            processRequest();
        }

        if (messageSize == 0) {
            bytesRead = read(fd, (void *) &messageSize, 4);
            if (bytesRead == 0) {
                closeConnection();
                return;
            } else if (bytesRead <= 0) {
                return;
            } else {
                bytesReceived += bytesRead;
                messageSize = ntohl(messageSize);
                readData = 0;
            }
        }

        if (readData < messageSize) {
            if (readData == 0) {
                messageBuffer.resize(messageSize);
            }
            bytesRead = read(fd, &messageBuffer[readData], messageSize - readData);
            if (bytesRead == 0) {
                closeConnection();
                return;
            } else if (bytesRead <= 0) {
                return;
            } else {
                bytesReceived += bytesRead;
                readData += bytesRead;
            }
        }
    }
}

void Server::closeConnection() {
    unregisterFd();
    close(fd);
    delete this;
//    printf("Server closed\n");
}

void Server::processRequest() {
    Request request;
    request.ParseFromString(messageBuffer);
    Response response = getResponse(request);
    sendResponse(response);
}

Server::Server(int cfd, EpollInstance &e) : ServerAbstract(-1, e) {
    fd = cfd;
    registerFd(EPOLLIN | EPOLLET);
//    printf("New Server created\n");
}

// destructor
Server::~Server() {
//    printf("Server destroyed\n");
}
