package server;
import cz.cvut.fel.esw.server.proto.Request;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

public class Application {

    public Application() {}

    public void start() throws InterruptedException {
        new EfficientServer().start();
    }

    public static void main(String[] args) throws Exception {
//        String port = args[0];
//        new Application(Integer.parseInt(port)).start();
        new EfficientServer().start();
    }
}





























//package server;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelOption;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//
//public class Application {
//    private static final int TCP_PORT = 12347;
//
//    public void run() throws Exception {
//
//        // Create the multithreaded event loops for the server
//        EventLoopGroup bossGroup = new NioEventLoopGroup();
//        EventLoopGroup workerGroup = new NioEventLoopGroup();
//
//        try {
//            // A helper class that simplifies server configuration
//            ServerBootstrap bootStrap = new ServerBootstrap();
//
//            // Configure the server
//            bootStrap.group(bossGroup, workerGroup)
//                    .channel(NioServerSocketChannel.class)
//                    .childHandler(new ServerPipeline())
//                    .option(ChannelOption.SO_BACKLOG, 128)
//                    .childOption(ChannelOption.SO_KEEPALIVE, true);
//
//            // Bind and start to accept incoming connections.
//            System.out.println("Server started");
//
//            ChannelFuture channelFuture = bootStrap.bind(TCP_PORT).sync();
//            channelFuture.channel().closeFuture().sync();
//        }
//        finally {
//            System.out.println("Server shut down gracefully..");
//            workerGroup.shutdownGracefully();
//            bossGroup.shutdownGracefully();
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        new Application().run();
//    }
//}
