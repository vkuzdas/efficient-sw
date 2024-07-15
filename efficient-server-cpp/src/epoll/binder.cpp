#include <unistd.h>
#include <cstdio>
#include <string>
#include "binder.h"

#include <sys/socket.h>
#include <sys/types.h>
#include <arpa/inet.h>
#include <fcntl.h>

SocketBinder::SocketBinder(EpollInstance &e, int port) : ServerAbstract(-1, e), ep(e) {
    printf("Binding to port %d\n", port);

    int sfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sfd < 0) {
        printf("Error while creating socket\n");
    }

    struct sockaddr_in receive_addr{};
    receive_addr.sin_family = AF_INET;
    receive_addr.sin_port = htons(port);
    receive_addr.sin_addr.s_addr = INADDR_ANY;

    if (bind(sfd, (struct sockaddr *) &receive_addr, sizeof(receive_addr)) < 0) {
        printf("Couldn't bind to the port\n");
    }

    auto listen_res = listen(sfd, SOMAXCONN);
    if (listen_res < 0) {
        printf("Couldn't listen to the port\n");
    }

    fd = sfd;
    registerFd(EPOLLIN | EPOLLHUP);
}

SocketBinder::~SocketBinder() {
    unregisterFd();
}

void SocketBinder::handleEvent(int events) {
    std::string line;
    if ((events & EPOLLERR) || (events & EPOLLHUP) || !(events & EPOLLIN)) {
        unregisterFd();
    } else {
        int cfd = accept4(fd, nullptr, nullptr, O_NONBLOCK);
        auto *conn = new Server(cfd, ep);
    }
}
