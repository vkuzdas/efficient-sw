#include "fd.h"

ServerAbstract::ServerAbstract(int fd, EpollInstance &e) : fd(fd), epollInstance(e) {}

ServerAbstract::~ServerAbstract() = default;

void ServerAbstract::registerFd(int events) {
    epollInstance.registerFd(*this, events);
}

void ServerAbstract::unregisterFd() {
    epollInstance.unregisterFd(*this);
}
