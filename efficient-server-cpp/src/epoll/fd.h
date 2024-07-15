#ifndef ABSTRACT_SERVER_H
#define ABSTRACT_SERVER_H

#include <stdint.h>
#include "instance.h"

class ServerAbstract {
public:
    ServerAbstract(int fd, EpollInstance &e);

    ~ServerAbstract();

    void registerFd(int events);

    void unregisterFd();

    virtual void handleEvent(int events) = 0;

    int fd;
    EpollInstance &epollInstance;



};

#endif // ABSTRACT_SERVER_H
