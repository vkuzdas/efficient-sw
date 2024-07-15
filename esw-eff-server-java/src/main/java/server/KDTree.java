package server;

import cz.cvut.fel.esw.server.proto.Location;

import java.util.*;

public class KDTree {
    private static final double FIFTY_CM = 500.0; // in mm
    private static final double FIFTY_CM_SQRD = 250000.0; // in mm^2
    private static final int DIMENSIONS = 2; // 2D tree
    private static final int NOT_FOUND = -1;

    public List<Node> nodes;

    public KDTree() {
        nodes = new ArrayList<>();
    }

    public long insert(Point point) {
        if (nodes.isEmpty()) {
            nodes.add(new Node(point));
            return nodes.get(0).id;
        }

        int depth = 0;
        Node currentNode = nodes.get(0);
        while (true) {
            int cd = depth % DIMENSIONS;
            boolean currIsLesser = point.coords[cd] < currentNode.coords[cd];
            long nextNodeId = currIsLesser ? currentNode.left : currentNode.right;

            if (nextNodeId == NOT_FOUND) {
                nodes.add(new Node(point));
                Node newNode = nodes.get(nodes.size() - 1);
                if (currIsLesser)
                    currentNode.left = newNode.id;
                else
                    currentNode.right = newNode.id;
                return newNode.id;
            } else {
                currentNode = nodes.get((int) nextNodeId);
                depth++;
            }
        }
    }



    public long findNear(Point point) {
        return searchTree(0, point, 0);
    }

    private long searchTree(long nodeId, Point point, int depth) {
        while (nodeId != NOT_FOUND && !nodes.isEmpty()) {
            if (inProximity(point, nodeId))
                return nodeId;

            int cd = depth % DIMENSIONS;
            Node currentNode = nodes.get((int) nodeId);

            long ret = NOT_FOUND;
            if (point.coords[cd] - FIFTY_CM <= currentNode.coords[cd])
                ret = searchTree(currentNode.left, point, depth + 1);

            if (ret == NOT_FOUND && point.coords[cd] + FIFTY_CM >= currentNode.coords[cd])
                ret = searchTree(currentNode.right, point, depth + 1);

            return ret;
        }

        return NOT_FOUND;
    }



    public long oneToAll(long src) {
        PriorityQueue<DistancePair> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(dp -> dp.distance));
        long[] distFromSrc = new long[nodes.size()];
        Arrays.fill(distFromSrc, Long.MAX_VALUE);
        distFromSrc[(int) src] = 0;

        priorityQueue.add(new DistancePair(0, src));

        while (!priorityQueue.isEmpty()) {
            DistancePair current = priorityQueue.poll();
            long currentDist = current.distance;
            long currentId = current.nodeId;

            Node currentNode = nodes.get((int) currentId);
            for (Map.Entry<Long, Edge> entry : currentNode.nbrs.entrySet()) {
                long nbrId = entry.getKey();
                Edge nbr = entry.getValue();
                long newDist = currentDist + nbr.dist / nbr.count;
                if (newDist < distFromSrc[(int) nbrId]) {
                    priorityQueue.add(new DistancePair(newDist, nbrId));
                    distFromSrc[(int) nbrId] = newDist;
                }
            }
        }

        long sum = 0;
        for (long dist : distFromSrc) {
            if (dist != Long.MAX_VALUE)
                sum += dist;
        }

        return sum;
    }

    public long oneToOne(long src, long dst) {
        long[] distFromSrc = new long[nodes.size()];
        Arrays.fill(distFromSrc, Long.MAX_VALUE);
        distFromSrc[(int) src] = 0;

        long[] prev = new long[nodes.size()];
        Arrays.fill(prev, NOT_FOUND);

        PriorityQueue<DistancePair> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(dp -> dp.distance));
        priorityQueue.add(new DistancePair(0, src));

        while (!priorityQueue.isEmpty()) {
            DistancePair current = priorityQueue.poll();
            if (current.nodeId == dst)
                break;

            Node currentNode = nodes.get((int) current.nodeId);
            for (Map.Entry<Long, Edge> entry : currentNode.nbrs.entrySet()) {
                long nbrId = entry.getKey();
                Edge nbr = entry.getValue();
                long newDist = current.distance + nbr.dist / nbr.count;
                if (newDist < distFromSrc[(int) nbrId]) {
                    priorityQueue.add(new DistancePair(newDist, nbrId));
                    distFromSrc[(int) nbrId] = newDist;
                    prev[(int) nbrId] = current.nodeId;
                }
            }
        }

        return distFromSrc[(int) dst];
    }

    public boolean inProximity(Point a, long nodeId) {
        long nodeX = nodes.get((int) nodeId).coords[0];
        long nodeY = nodes.get((int) nodeId).coords[1];
        double dx = a.coords[0] - nodeX;
        double dy = a.coords[1] - nodeY;
        return dx * dx + dy * dy <= FIFTY_CM_SQRD;
    }

    public static class Node {
        long id;
        static long idCount;
        long[] coords;
        long left;
        long right;
        Map<Long, Edge> nbrs;

        Node(Point point) {
            coords = new long[2];
            coords[0] = point.coords[0];
            coords[1] = point.coords[1];
            left = -1;
            right = -1;
            id = idCount++;
            nbrs = new HashMap<>();
        }

        void addNeighbor(int dist, long neighborId) {
            if (nbrs.containsKey(neighborId)) {
                Edge edge = nbrs.get(neighborId);
                edge.dist += dist;
                edge.count++;
            } else {
                nbrs.put(neighborId, new Edge(dist, 1));
            }
        }
    }

    private static class Edge {
        long dist;
        int count;

        Edge(long dist, int count) {
            this.dist = dist;
            this.count = count;
        }
    }

    public static class Point {
        long[] coords;

        Point(Location location) {
            coords = new long[2];
            coords[0] = location.getX();
            coords[1] = location.getY();
        }
    }

    private static class DistancePair {
        long distance;
        long nodeId;

        DistancePair(long distance, long nodeId) {
            this.distance = distance;
            this.nodeId = nodeId;
        }
    }
}
