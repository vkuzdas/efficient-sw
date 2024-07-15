package server;

import cz.cvut.fel.esw.server.proto.Location;
import cz.cvut.fel.esw.server.proto.Request;
import cz.cvut.fel.esw.server.proto.Response;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static cz.cvut.fel.esw.server.proto.Request.MsgCase.*;

public class EfficientServer extends SimpleChannelInboundHandler<Request> {


    public KDTree tree = new KDTree();
    ConcurrentHashMap<Integer, Request> walks = new ConcurrentHashMap<>();
    ConcurrentHashMap<Integer, Request> one2one = new ConcurrentHashMap<>();
    ConcurrentHashMap<Integer, Request> one2all = new ConcurrentHashMap<>();
    ConcurrentHashMap<Integer, Request> notSet = new ConcurrentHashMap<>();
    AtomicInteger walkCounter = new AtomicInteger(0);
    AtomicInteger one2oneCounter = new AtomicInteger(0);
    AtomicInteger one2AllCounter = new AtomicInteger(0);
    AtomicInteger notSetCounter = new AtomicInteger(0);
    public EventLoopGroup bossGroup;
    public EventLoopGroup workerGroup;


    public void start() throws InterruptedException {
        int PORT = 6794;
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        try {
            Logger.log("Server starting on port " + PORT);
            ServerBootstrap bootStrap = new ServerBootstrap();
            // Configure the server
            bootStrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ServerPipeline())
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);


            ChannelFuture channelFuture = bootStrap.bind(PORT).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }


    public boolean inProximity(double[] p1, double[] p2) {
        double distance = Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
        return distance <= 500;
    }


    @Override
    public void channelRead0(ChannelHandlerContext ctx, Request request) {
        Response res;
        switch (request.getMsgCase()) {
            case WALK:
                // set to graph
                long src_id = -1;
                long dst_id = -1;
                List<Location> vertices = request.getWalk().getLocationsList();
                List<Integer> lengths = request.getWalk().getLengthsList();
                for (int i = 0; i < lengths.size(); i++) {
                    KDTree.Point src = new KDTree.Point(vertices.get(i));
                    KDTree.Point dst = new KDTree.Point(vertices.get(i + 1));

                    src_id = dst_id;
                    if (src_id == -1)
                        src_id = tree.findNear(src);
                    if (src_id == -1)
                        src_id = tree.insert(src);

                    dst_id = tree.findNear(dst);
                    if (dst_id == -1)
                        dst_id = tree.insert(dst);

                    // TODO: different structure - array of di_pairs??
                    // Add the destination node ID as a neighbor to the source node with the corresponding walk length
                    tree.nodes.get((int) src_id).addNeighbor(request.getWalk().getLengths(i), dst_id);
                }
                break;
            case ONETOONE:
                // A*
                // Dijkstra/Ford?
                KDTree.Point src = new KDTree.Point(request.getOneToOne().getOrigin());
                KDTree.Point dst = new KDTree.Point(request.getOneToOne().getDestination());
                long src_id2 = tree.findNear(src);
                long dst_id2 = tree.findNear(dst);

                long r2 = tree.oneToOne(src_id2, dst_id2);

                Logger.log("ONETOALL " + r2);
                Logger.log(tree.nodes.size()+"");
                break;
            case ONETOALL:
                // Dijkstra/Ford?
                KDTree.Point src_id3 = new KDTree.Point(request.getOneToAll().getOrigin());
                long src_id4 = tree.findNear(src_id3);
                long r3 = tree.oneToAll(src_id4);

                Logger.log("ONETOALL " + r3);
                Logger.log(tree.nodes.size()+"");




                break;
            case MSG_NOT_SET:
                notSet.put(notSetCounter.getAndIncrement(), request);
                Logger.log("MSG_NOT_SET"+notSetCounter.get()+" added");
                Logger.log(tree.nodes.size()+"");
                break;
        }

        res = Response.newBuilder()
                .setStatus(Response.Status.OK)
                .setShortestPathLength(420)
                .build();


        ctx.writeAndFlush(res);
    }

//    @Override
//    public void channelReadComplete(ChannelHandlerContext ctx) {
//        ctx.flush();
//    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }



    public static class ServerPipeline extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel ch) {
            ChannelPipeline p = ch.pipeline();
            p.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
            p.addLast(new ProtobufDecoder(Request.getDefaultInstance()));
            p.addLast(new ProtobufVarint32LengthFieldPrepender());
            p.addLast(new ProtobufEncoder());
            p.addLast(new EfficientServer());

        }
    }


}
