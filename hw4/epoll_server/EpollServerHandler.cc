#include <arpa/inet.h>
#include <fcntl.h>
#include <iostream>
#include <string.h>
#include <string>
#include <sys/epoll.h>
#include <sys/socket.h>
#include "EpollServerHandler.hh"
#include "EpollEchoHandler.hh"
#include "EpollInstance.hh"

#include <sys/socket.h>
#include <sys/types.h>
#include <arpa/inet.h>
#include <fcntl.h>
#include <unistd.h>

EpollServerHandler::EpollServerHandler(EpollInstance *instance) {
    this->instance = instance;
    auto fd = socket(AF_INET, SOCK_STREAM, 0);

    short int port = 12345;
    struct sockaddr_in saddr{};

    memset(&saddr, 0, sizeof(saddr));
    saddr.sin_family = AF_INET;
    saddr.sin_addr.s_addr = htonl(INADDR_ANY);
    saddr.sin_port = htons(port);

    bind(fd, (struct sockaddr *)&saddr, sizeof(saddr));

    int flags = fcntl(fd, F_GETFL, 0);
    flags |= O_NONBLOCK;
    fcntl(fd, F_SETFL, flags);
    listen(fd, SOMAXCONN);

    this->set_fd(fd);
    this->set_events(EPOLLIN);
}

EpollServerHandler::~EpollServerHandler() {
    instance->unregisterEpollEntry(*this);
    close(this->get_fd());
    delete this;
}

bool EpollServerHandler::handleEvent(uint32_t events) {
    if ((events & EPOLLERR) || (events & EPOLLHUP) || !(events & EPOLLIN))
        return false;
    int fd =  accept(this->get_fd(), nullptr, nullptr);
    new EpollEchoHandler(fd, instance);
    return true;
}