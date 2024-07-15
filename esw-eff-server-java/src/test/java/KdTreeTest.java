//import cz.cvut.fel.esw.server.proto.Location;
//import org.junit.jupiter.api.Test;
//import server.KdTree;
//import server.Node;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class KdTreeTest {
//
//    @Test
//    public void insertEdge() {
//        Location l1 = Location.newBuilder().setX(12).setY(41).build();
//        Location l2 = Location.newBuilder().setX(600).setY(3464).build();
//        Node n1 = new Node(l1);
//        Node n2 = new Node(l2);
//        assertFalse(n1.inProximity(n2));
//
//        KdTree tree = new KdTree();
//        tree.insertEdge(l1, l2, 3000);
//        assertEquals(tree.size, 2);
//    }
//
//    @Test
//    public void insertPath() {
//        Location l1 = Location.newBuilder().setX(12).setY(41).build();
//        Location l2 = Location.newBuilder().setX(600).setY(3464).build();
//        Location l3 = Location.newBuilder().setX(3000).setY(6000).build();
//        Node n1 = new Node(l1);
//        Node n2 = new Node(l2);
//        Node n3 = new Node(l2);
//        assertFalse(n1.inProximity(n2));
//        assertFalse(n1.inProximity(n3));
//
//        KdTree tree = new KdTree();
//        tree.insertEdge(l1, l2, 3000);
//        tree.insertEdge(l2, l3, 3000);
//        assertEquals(tree.size, 3);
//    }
//
////    @Test
////    public void contains() {
////        KdTree tree = new KdTree();
////        Node n1 = new Node(new int[]{0, 0});
////        Node n2 = new Node(new int[]{500, 0});
////        Node n3 = new Node(new int[]{501, 0});
////
////        tree.insertNode(n1);
////        // contains node in proximity
////        assertTrue(n1.inProximity(n2));
////        assertEquals(tree.indexOf(n2), 0);
////
////        // does NOT contain node in proximity
////        assertFalse(n1.inProximity(n3));
////        assertEquals(tree.indexOf(n3), -1);
////    }
//
//    @Test
//    public void proximityNodeTest() {
//        Node n1 = new Node(new int[]{0, 0});
//        Node n2 = new Node(new int[]{499, 0});
//        Node n3 = new Node(new int[]{500, 0});
//        Node n4 = new Node(new int[]{501, 0});
//        Node n5 = new Node(new int[]{0, 499});
//        Node n6 = new Node(new int[]{0, 500});
//        Node n7 = new Node(new int[]{0, 501});
//        assertTrue(n1.inProximity(n2));
//        assertTrue(n1.inProximity(n3));
//        assertFalse(n1.inProximity(n4));
//        assertTrue(n1.inProximity(n5));
//        assertTrue(n1.inProximity(n6));
//        assertFalse(n1.inProximity(n7));
//
//
//        Node n8 = new Node(new int[]{0, 0});
//        Node n9 = new Node(new int[]{-500, 0});
//        Node n10 = new Node(new int[]{0, -500});
//        assertTrue(n8.inProximity(n9));
//        assertTrue(n9.inProximity(n8));
//        assertFalse(n9.inProximity(n10));
//        assertTrue(n8.inProximity(n10));
//    }
//
////    @Test
////    public void proximityInsert_identical() {
////        Node n1 = new Node(new int[]{0, 0});
////        Node n2 = new Node(new int[]{0, 0});
////        KdTree tree = new KdTree();
////
////        tree.insertNode(n1);
////        assertEquals(1, tree.size());
////        tree.insertNode(n2);
////        assertEquals(1, tree.size());
////        assertEquals(tree.root.point[0], 0);
////        assertEquals(tree.root.point[1], 0);
////    }
//
////    @Test
////    public void proximityInsert_average() {
////        Node n1 = new Node(new int[]{0, 0});
////        Node n2 = new Node(new int[]{10, 10});
////        Node n3 = new Node(new int[]{15, 15});
////        Node n4 = new Node(new int[]{700, 700});
////        KdTree tree = new KdTree();
////
////        tree.insertNode(n1);
////        tree.insertNode(n2);
////        // points in proximity are identical
////        assertTrue(n1.inProximity(n2));
////        assertEquals(1, tree.size());
////        assertEquals(tree.root.point[0], 0);
////        assertEquals(tree.root.point[1], 0);
////
////        tree.insertNode(n3);
////        // points in proximity are identical
////        assertTrue(n1.inProximity(n3));
////        assertEquals(1, tree.size());
////        assertEquals(tree.root.point[0], 0);
////        assertEquals(tree.root.point[1], 0);
////
////        assertFalse(tree.root.inProximity(n4));
////        tree.insertNode(n4);
////        // KdTree should split the Node, there should be two Nodes with points [5, 5] and [70, 70]
////        assertEquals(2, tree.size());
////        assertEquals(tree.root.point[0], 0);
////        assertEquals(tree.root.point[1], 0);
////    }
//
//}
