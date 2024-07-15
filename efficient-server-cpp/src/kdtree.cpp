#include <cstdint>
#include <iostream>
#include "stdio.h"
#include "kdtree.h"
#include <queue>
#include <algorithm>
#include <execution>
#include <numeric>
#include <cstdint>
#include <limits>
#include <limits>

using namespace std;
using weight_id = pair<uint64_t,int64_t>; /// {distance, id}

KDTree tree;

int64_t Vertex::id_count = 0;
const double FIFTY_CM = 500.0; /// in mm
const double FIFTY_CM_SQRD = 250000.0; /// in mm^2
const int DIMENSIONS = 2; /// 2D tree
const int NOT_FOUND = -1;


KDTree::KDTree() {
}


bool KDTree::inProximity(Point a, int64_t nodeId) {
    int64_t nodeX = vertices[nodeId].coords[0];
    int64_t nodeY = vertices[nodeId].coords[1];
    auto dx = (double) (a.coords[0] - nodeX);
    auto dy = (double) (a.coords[1] - nodeY);
    return dx * dx + dy * dy <= FIFTY_CM_SQRD;
}


uint64_t KDTree::oneToAll(int64_t src) {
    priority_queue<weight_id, vector<weight_id>, greater<weight_id>> PQ; /// Min heap
    vector<uint64_t> dist_from_src(vertices.size(), UINT64_MAX);
    dist_from_src[src] = 0;

    PQ.emplace(0, src);

    // Dijkstra's algorithm to find shortest paths
    while (!PQ.empty()) {
        // Extract the node with the minimum distance from the priority queue
        weight_id curr = PQ.top(); PQ.pop();
        auto curr_dist = curr.first;
        auto curr_id = curr.second;

        // Iterate over the nbrs of the current node
        for (auto nbr : vertices[curr_id].nbrs) {
            auto nbr_id = nbr.first;
            weight_count pair = nbr.second;
            uint64_t new_dist = curr_dist + pair.first / pair.second; /// average distance
            // If the new path is not shorter, skip it
            if (new_dist >= dist_from_src[nbr_id])
                continue;

            PQ.emplace(new_dist, nbr_id);
            dist_from_src[nbr_id] = new_dist;
        }
    }

    // parallel sum
    uint64_t sum = std::transform_reduce(std::execution::par, dist_from_src.begin(), dist_from_src.end(), 0ULL,
                                         std::plus<>(), [](uint64_t dist) {
                return dist == UINT64_MAX ? 0ULL : dist;
            });

    return sum;
}



uint64_t KDTree::oneToOne(int64_t src, int64_t dst) {

    vector<uint64_t> dist_from_src(vertices.size(), UINT64_MAX);
    dist_from_src[src] = 0;

    vector<int64_t> prev(vertices.size(), NOT_FOUND);
    vector<bool> closed(vertices.size(), false);

    priority_queue<weight_id, vector<weight_id>, greater<weight_id>> PQ;
    PQ.emplace(0, src);


    while (!PQ.empty()) {

        if (PQ.top().second != dst) {
            weight_id curr = PQ.top();
            PQ.pop();

            for_each(execution::par_unseq, vertices[curr.second].nbrs.begin(), vertices[curr.second].nbrs.end(), [&](auto& nbr) {
                int64_t nbr_id = nbr.first;
                weight_count pair = nbr.second;
                int new_dist = curr.first + pair.first / pair.second;
                if (new_dist < dist_from_src[nbr_id]) {
                    PQ.emplace(new_dist, nbr_id);
                    dist_from_src[nbr_id] = new_dist;
                    prev[nbr_id] = curr.second;
                }
            });
        } else break;
    }
    return dist_from_src[dst];
}


int64_t KDTree::insertRec(int64_t nodeId, Point point, int depth) {
    if (!vertices.empty()) {
        int cd = depth % DIMENSIONS;
        /// current node is lesser than the node we are trying to add
        bool curr_is_lesser = point.coords[cd] < vertices[nodeId].coords[cd];
        int64_t nextNodeId = curr_is_lesser ? vertices[nodeId].left : vertices[nodeId].right;

        if (nextNodeId != NOT_FOUND) {
            return insertRec(nextNodeId, point, ++depth);
        } else {
            vertices.emplace_back(point);
            curr_is_lesser ? vertices[nodeId].left = vertices.back().id : vertices[nodeId].right = vertices.back().id;
            return vertices.back().id;
        }
    } else {
        vertices.emplace_back(point);
        return vertices.back().id;

    }
}

int64_t KDTree::insert(Point point) {
    return insertRec(0, point, 0);
}


int64_t KDTree::searchTree(int64_t nodeId, Point point, int depth) {
    if (nodeId != NOT_FOUND && !vertices.empty()) {

        if (!inProximity(point, nodeId)) {

            int cd = depth % DIMENSIONS;
            int64_t ret = NOT_FOUND;
            if (point.coords[cd] - FIFTY_CM <= vertices[nodeId].coords[cd])
                ret = searchTree(vertices[nodeId].left, point, depth + 1);

            if (ret == NOT_FOUND && point.coords[cd] + FIFTY_CM >= vertices[nodeId].coords[cd])
                ret = searchTree(vertices[nodeId].right, point, depth + 1);

            return ret;
        } else return nodeId;
    } else return NOT_FOUND;
}

int64_t KDTree::searchProximity(Point point) {
    return searchTree(0, point, 0);
}


