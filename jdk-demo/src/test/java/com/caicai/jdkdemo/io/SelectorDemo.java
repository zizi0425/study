package com.caicai.jdkdemo.io;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: SelectorDemo
 * @Package: com.caicai.jdkdemo.io
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/19 15:06
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class SelectorDemo {

    static int port = 9687;
    @Test
    public void client() throws IOException, InterruptedException {
        selectorClient();
        System.out.println("\"---\" = " + "---");
    }

    /**
     * 启动server后; client启动一次; server收到一次数据
     * @throws IOException
     * @throws InterruptedException
     */
    @Test
    public void server() throws IOException, InterruptedException {
        selectorServer();
    }


    public static void selectorServer() throws IOException {
        try (ServerSocketChannel channel = ServerSocketChannel.open()) {
            channel.configureBlocking(false);
            channel.bind(new InetSocketAddress(port));

            Selector selector = Selector.open();
            channel.register(selector, SelectionKey.OP_ACCEPT);
            while (selector.select() > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    if (selectionKey.isAcceptable()) {
                        SocketChannel socketChannel = channel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    }
                    if (selectionKey.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        int read = 0;
                        while ((read = socketChannel.read(byteBuffer)) != -1) {
                            byteBuffer.flip();
                            System.out.println(new String(byteBuffer.array()));
                            byteBuffer.clear();
                        }
                        socketChannel.close();
                    }
                    iterator.remove();
                }
            }
        }
    }

    public static void selectorClient() throws IOException {
        try (SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(port))) {
            socketChannel.configureBlocking(false);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put("hello world".getBytes());
            socketChannel.write(byteBuffer);
            byteBuffer.flip();
        }
    }

}
