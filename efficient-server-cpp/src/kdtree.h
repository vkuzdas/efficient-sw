#ifndef KDTREE_H
#define KDTREE_H


#include <cstdint>
#include <map>
#include <vector>
#include <shared_mutex>
#include "proto/messages.pb.h"

using namespace std;
using src_dest = pair<int64_t, int64_t>;
using weight_count = pair<int64_t, uint32_t>;



struct Point {
    uint32_t coords[2];

    Point(const Location& location) {
        coords[0] = location.x();
        coords[1] = location.y();
    }

};
class Vertex {
public:
    int64_t id;
    static int64_t id_count;
    uint32_t coords[2];
    int64_t left; // TODO pointers
    int64_t right;
    map<uint64_t, weight_count> nbrs;

    Vertex(Point point) {
        coords[0] = point.coords[0];
        coords[1] = point.coords[1];
        left = -1;
        right = -1;
        id = id_count++;
    }

};


class KDTree {
public:
    KDTree();

    vector<Vertex> vertices;
    map<src_dest, vector<uint64_t>> edges; /// source, destination and their weights


    bool inProximity(Point a, int64_t nodeId);

    int64_t insert(Point point);


    int64_t searchProximity(Point point);

    int64_t searchTree(int64_t nodeId, Point point, int depth);

    uint64_t oneToOne(int64_t src, int64_t dst);

    uint64_t oneToAll(int64_t src);

private:
    int64_t insertRec(int64_t nodeId, Point point, int depth);


};

extern KDTree tree;

#endif // KDTREE_H