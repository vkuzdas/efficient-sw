#ifndef SERVER_H
#define SERVER_H

#include <sys/epoll.h>
#include <string>
#include "fd.h"
#include "instance.h"

#include "../proto/messages.pb.h"


class Server : public ServerAbstract {
public:
    uint32_t messageSize = 0;

    int readData = 0;

    // TODO extract to .cpp
    std::string messageBuffer;

    Response getResponse(Request &request);

    void handleEvent(int events) override;

    void sendResponse(const Response &responseMessage);

    void closeConnection();

    void processRequest();

    Server(int cfd, EpollInstance &e);

    ~Server();

    void insertWalk(Walk &walk, int64_t src_id, int64_t dst_id);
};

#endif // SERVER_H
