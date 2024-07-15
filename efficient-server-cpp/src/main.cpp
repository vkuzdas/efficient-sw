#include <iostream>
#include "epoll/instance.h"
#include "epoll/binder.h"


using namespace std;
EpollInstance ep;


int main(int argc, char *argv[]) {


    SocketBinder socket(ep, atoi(argv[1]));
    for (;;) {
        ep.waitAndHandleEvents();
    }
    return 0;
}
