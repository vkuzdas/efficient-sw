#include "EpollInstance.hh"
#include "EpollStdIn.hh"
#include "EpollTimer.hh"
#include "EpollServerHandler.hh"
#include "EpollEchoHandler.hh"

using namespace std;

int main() {
    EpollInstance ep;
    EpollTimer tim1(1000);
    EpollTimer tim2(1500);
    EpollStdIn sin;
    EpollServerHandler conn(&ep);

    ep.registerEpollEntry(tim1);
    ep.registerEpollEntry(tim2);
    ep.registerEpollEntry(sin);
    ep.registerEpollEntry(conn);

    while (1) {
        ep.waitAndHandleEvents();
    }

    ep.unregisterEpollEntry(tim1);
    ep.unregisterEpollEntry(tim2);
    ep.unregisterEpollEntry(sin);
    ep.unregisterEpollEntry(conn);

    return 0;
}
