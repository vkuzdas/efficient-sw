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
    this->count = 0;
}

EpollEchoHandler::~EpollEchoHandler() {
    this->instance->unregisterEpollEntry(*this);
    close(this->get_fd());
    delete this;
}

#define BUFF_SIZE 64
bool EpollEchoHandler::handleEvent(uint32_t events) {
    if (events & EPOLLERR || events & EPOLLHUP || !(events & EPOLLIN))
        return false;

    if (events & EPOLLIN) {
        ssize_t read_count = read(this->get_fd(), buffer, BUFF_SIZE);
        for (ssize_t i = 0; i < read_count; i++) {
            if (buffer[i] != '\n') {
                count++;
            } else {
                dprintf(this->get_fd(), "%zu\n", count);
                count = 0;
            }
        }
        return true;
    }
    return false;
}