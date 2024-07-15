#include <cstdint>
#include <cstdio>
#include "EpollEntry.hh"
#include "EpollInstance.hh"

class EpollEchoHandler : public EpollEntry {
public:
    EpollEchoHandler(int fd, EpollInstance *instance);
    bool handleEvent(uint32_t events) override;
    ~EpollEchoHandler() override;
private:
    EpollInstance *instance;
    ssize_t count;
    char buffer[64]{};
};
