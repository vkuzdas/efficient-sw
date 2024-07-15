#ifndef EPOLLSTDIN_H
#define EPOLLSTDIN_H

#include <stdint.h>
#include "EpollEntry.hh"

class EpollStdIn : public EpollEntry
{
public:
    EpollStdIn();
    bool handleEvent(uint32_t events);
};

#endif // EPOLLSTDIN_H
