#ifndef EPOLLTIMERIN_H
#define EPOLLTIMERIN_H

#include <stdint.h>
#include "EpollEntry.hh"

class EpollTimer : public EpollEntry
{
public:
    EpollTimer(uint32_t timeMs);
    ~EpollTimer();
    bool handleEvent(uint32_t events);
};

#endif // EPOLLTIMERIN_H
