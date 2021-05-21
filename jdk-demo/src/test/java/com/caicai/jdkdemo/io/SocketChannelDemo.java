package com.caicai.jdkdemo.io;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: SocketDemo
 * @Package: com.caicai.jdkdemo.io
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/19 13:37
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class SocketChannelDemo {


    @Test
    public void test() throws InterruptedException {
        new Thread(() -> {
            try {
                client();
            } catch (Exception e) {
            }
        }).start();
        new Thread(() -> {
            try {
                server();
            } catch (Exception e) {
            }
        }).start();
        TimeUnit.SECONDS.sleep(50);

    }




    public void client() throws IOException, InterruptedException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try (SocketChannel channel = SocketChannel.open()) {
            channel.configureBlocking(false);
            channel.connect(new InetSocketAddress("127.0.0.1", 9956));
            boolean b = channel.finishConnect();
            if (b) {
                int i = 0;
                while (true) {
                    TimeUnit.SECONDS.sleep(2);
                    byteBuffer.clear();
                    String message = "hello world " + i++;
                    byteBuffer.put(message.getBytes());
                    byteBuffer.flip();
                    while (byteBuffer.hasRemaining()) {
                        channel.write(byteBuffer);
                    }
                }
            }
        }
    }

    public void server() throws IOException, InterruptedException  {
        try (ServerSocket serverSocket = new ServerSocket(9956)) {
            while (true) {
                Socket accept = serverSocket.accept();
                InputStream inputStream = accept.getInputStream();
                SimpleDemo.read(inputStream);

            }

        }
    }


}
