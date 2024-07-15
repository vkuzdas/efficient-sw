#ifndef INSTANCE_H
#define INSTANCE_H

#include <cstdint>


class ServerAbstract;

class EpollInstance {
public:
    void registerFd(ServerAbstract &fd, uint32_t events) const;

    void unregisterFd(ServerAbstract &fd) const;

    void waitAndHandleEvents() const;

    EpollInstance();

    ~EpollInstance();

    int epollFd;

};

#endif // INSTANCE_H
