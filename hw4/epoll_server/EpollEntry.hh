#ifndef EPOLL_ENTRY_HH
#define EPOLL_ENTRY_HH

#include <stdint.h>

class EpollEntry
{
public:
    /*! \brief How to react to epoll events?
     *
     * Return false if this should be removed from epoll instance.
     */
    virtual bool handleEvent(uint32_t events) = 0;

    /*! What file descriptor does this epoll entry wrap? */
    void set_fd(int i);
    int get_fd() const;

    /*! To what events react? */
    void set_events(uint32_t i);
    uint32_t get_events() const;

    virtual ~EpollEntry() = default;
private:
    int fd;
    uint32_t events;
};

#endif // EPOLL_ENTRY_HH
