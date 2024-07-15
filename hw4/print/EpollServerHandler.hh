#include <cstdint>
#include "EpollEntry.hh"
#include "EpollInstance.hh"

class EpollServerHandler : public EpollEntry {
public:
    EpollServerHandler(EpollInstance *instance);
    bool handleEvent(uint32_t events) override;
    ~EpollServerHandler() override;
private:
    EpollInstance *instance;
};
