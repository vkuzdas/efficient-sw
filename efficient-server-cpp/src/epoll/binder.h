#ifndef BINDER_H
#define BINDER_H

#include <sys/epoll.h>
#include <vector>
#include "fd.h"
#include "instance.h"
#include "server.h"
#include <list>

class SocketBinder : public ServerAbstract {
public:
    void handleEvent(int events) override;

    SocketBinder(EpollInstance &e, int port);

    ~SocketBinder();

    EpollInstance &ep;

    std::list<Server *> conns;
};

#endif // BINDER_H
