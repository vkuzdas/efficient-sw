#include <iostream>
#include <unistd.h>
#include <stdio.h>
#include <string>
#include <sys/epoll.h>

#include "EpollStdIn.hh"

EpollStdIn::EpollStdIn()
{
    this->set_fd(STDIN_FILENO);
    this->set_events(EPOLLIN);
}

bool
EpollStdIn::handleEvent(uint32_t events)
{
    std::string line;
    if ((events & EPOLLERR) || (events & EPOLLHUP) || !(events & EPOLLIN)) {
        return false;
    } else {
        std::getline(std::cin, line);
        std::cout << "stdin line: " << line << std::endl;
        return true;
    }
}
