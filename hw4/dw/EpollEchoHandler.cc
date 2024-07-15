#include "EpollEchoHandler.hh"
#include <iostream>
#include <stdio.h>
#include <sys/epoll.h>
#include <unistd.h>

EpollEchoHandler::EpollEchoHandler(int fd, EpollInstance *instance) {
    this->set_fd(fd);
    this->set_events(EPOLLIN);
    instance->registerEpollEntry(*this);
    this->instance = instance;
}

EpollEchoHandler::~EpollEchoHandler() {
    this->instance->unregisterEpollEntry(*this);
    close(this->get_fd());
    delete this;
}

#define BUFF_SIZE 64
bool EpollEchoHandler::handleEvent(uint32_t events) {
    char buffer[BUFF_SIZE];
    int count = 0;
    if (events & EPOLLERR || events & EPOLLHUP) {
        return false;
    }
    else if (events & EPOLLIN) {
        int fd = this->get_fd();
        ssize_t char_count = read(fd, buffer, BUFF_SIZE);
        for (auto i = 0; i < char_count; i++) {
            if (buffer[i] != '\n') {
                count++;
            } else {
                dprintf(fd, "%d\n", count);
                count = 0;
            }
        }
    }
    return true;
}