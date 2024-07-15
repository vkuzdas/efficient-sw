import cz.cvut.fel.esw.server.proto.Response;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import server.Logger;

public class TestClient {


    private ArrayList<Response> responses = new ArrayList<>();

    public ArrayList getResponses() {
        return responses;
    }


    public void start(String filePath) throws InterruptedException, IOException {
        int PORT = 6794;
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Logger.log("Client sending file to port " + PORT);
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new MyClientInitializer());

            byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
            ChannelFuture future = bootstrap.connect("localhost", PORT).sync();

            future.channel().writeAndFlush(Unpooled.copiedBuffer(fileBytes));
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    public class MyClientInitializer extends ChannelInitializer<SocketChannel> {
        @Override
        public void initChannel(SocketChannel ch) {
            ChannelPipeline p = ch.pipeline();
            p.addLast (new ProtobufVarint32FrameDecoder());
            p.addLast(new ProtobufDecoder(Response.getDefaultInstance()));
            p.addLast(new MyClientHandler());
        }
    }

    public class MyClientHandler extends SimpleChannelInboundHandler<Response> {
        @Override
        public void channelRead0(ChannelHandlerContext ctx, Response msg) {
            responses.add(msg);
        }
        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            cause.printStackTrace();
            ctx.close();
        }
    }


}
