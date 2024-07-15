#include <unistd.h>
#include <sys/epoll.h>
#include <cstring>
#include <stdexcept>
#include "instance.h"
#include "fd.h"
#include <thread>



void EpollInstance::registerFd(ServerAbstract &fd, uint32_t events) const {
    struct epoll_event ev{};
    memset(&ev, 0, sizeof(ev));

    ev.events = events;
    ev.data.ptr = &fd;

    if (epoll_ctl(epollFd, EPOLL_CTL_ADD, fd.fd, &ev) == -1) {
        throw std::runtime_error(std::string("epoll_ctl: ") + std::strerror(errno));
    }
}

void EpollInstance::unregisterFd(ServerAbstract &fd) const {
    struct epoll_event ev{};
    memset(&ev, 0, sizeof(ev));

    ev.events = 0;
    ev.data.ptr = &fd;

    if (epoll_ctl(epollFd, EPOLL_CTL_DEL, fd.fd, &ev) == -1) {
        throw std::runtime_error(std::string("epoll_ctl: ") + std::strerror(errno));
    }
}
#define EVENTS 32

void EpollInstance::waitAndHandleEvents() const {
    struct epoll_event events[EVENTS];
    int i, n;
    n = epoll_wait(epollFd, events, EVENTS, -1);
    if (n == -1) {
        throw std::runtime_error(std::string("epoll_wait: ") + std::strerror(errno));
    }
    for (i = 0; i < n; i++) {
        auto *fd = static_cast<ServerAbstract *>(events[i].data.ptr);
        fd->handleEvent(events[i].events);
    }
}


EpollInstance::~EpollInstance() {
    close(epollFd);
}

EpollInstance::EpollInstance() {
    epollFd = epoll_create1(0);
    if (epollFd == -1) {
        throw std::runtime_error(std::string("epoll_create1: ") + std::strerror(errno));
    }
}
