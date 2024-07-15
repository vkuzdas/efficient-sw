cmake_minimum_required(VERSION 3.25)
project(epoll_server)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)

add_executable(epoll_server
        EpollEntry.cc
        EpollEntry.hh
        EpollInstance.cc
        EpollInstance.hh
        EpollStdIn.cc
        EpollStdIn.hh
        EpollTimer.cc
        EpollTimer.hh
        main.cc EpollServerHandler.hh EpollServerHandler.cc EpollEchoHandler.cc EpollEchoHandler.hh)
