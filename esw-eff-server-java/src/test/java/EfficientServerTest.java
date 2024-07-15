//import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.EfficientServer;
import server.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EfficientServerTest {

    private static final int PORT = 6794;
    private EfficientServer server; // server
    private TestClient client;
    private Thread serverThread;
    private long startTime;


    @BeforeEach
    public void before() {
        setupServer();
        startTime = System.currentTimeMillis();
        System.out.println("");
        Logger.log("##########    TEST STARTED    #########");
        System.out.println("-------------------------");
    }

    private void setupServer() {
        server = new EfficientServer();
        serverThread = new Thread(() -> {
            try {
                server.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        serverThread.start();
    }

    @AfterEach
    public void after() {
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("-------------------------");
        Logger.log("##########    TEST ENDED    #########");

    }

    public void sendFile(String filePath) {
        client = new TestClient();
        Thread clientThread = new Thread(() -> {
            try {
                client.start(filePath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        clientThread.start();
    }


    /**
     * # walks: 1
     * # locations: 3
     * OneToOne.shortest_path_length = 161855
     * OneToAll.total_length = 58260
//     */
    @Test
    public void simpleShort() throws Exception {
        sendFile("src/test/resources/proto/walk1nodes3-2.pbf");

        Thread.sleep(1000); // wait for response to be received
        assertEquals(3, client.getResponses().size());
    }

    /**
     * # walks: 1
     * # locations: 100
     * OneToOne.shortest_path_length = 19545308
     * OneToAll.total_length = 941824954
     */
//    @Test
    public void simpleLong() throws Exception {
        sendFile("src/test/resources/proto/walk1nodes100-2.pbf");

        Thread.sleep(1000); // wait for response to be received
        assertEquals(3, client.getResponses().size());
    }

    /**
     * # walks: 2
     * # locations: 6
     * OneToOne.shortest_path_length = 41691
     * OneToAll.total_length = 664267
     */
//    @Test
    public void twoWalksCommonEdge() throws Exception {
        sendFile("src/test/resources/proto/walk2nodes6.pbf");

        Thread.sleep(1000); // wait for response to be received
        assertEquals(3, client.getResponses().size());
    }

    /**
     * # walks: 3000
     * # locations: 1679366
     * OneToOne.shortest_path_length = 248408794
     * OneToAll.total_length = 23914104899237
     */
    @Test
    public void performance() throws Exception {
        sendFile("src/test/resources/proto/walk3000.pbf");

        Thread.sleep(7000); // wait for response to be received
//        System.out.println("size: " + server.tree.size);
        assertEquals(3002, client.getResponses().size());
//        assertEquals(607, server.tree.size);
//        assertEquals(3002, server.tree.adjList.size());
    }


}