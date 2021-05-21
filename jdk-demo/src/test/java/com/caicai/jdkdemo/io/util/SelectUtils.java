package com.caicai.jdkdemo.io.util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: SelectUtil
 * @Package: com.caicai.jdkdemo.io.util
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/19 15:14
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class SelectUtils {

    static final int BUFFER_SIZE = 1024;
    public static void handlerAccept(SelectionKey key) throws IOException {
        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
        try (SocketChannel accept = channel.accept()) {
            accept.configureBlocking(false);
            accept.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocateDirect(BUFFER_SIZE));
        }
    }

    public static void handlerRead(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
        int read = channel.read(byteBuffer);
        while (read > 0) {
            byteBuffer.flip();
            byte[] bytes = new byte[byteBuffer.capacity()];
            int index = 0;
            while (byteBuffer.hasRemaining()) {
                bytes[index] = byteBuffer.get();
            }
            String s = new String(bytes, "utf-8");
            System.out.println("s = " + s);
            byteBuffer.clear();
            read = channel.read(byteBuffer);
        }
        channel.close();
    }

    public static void handlerWrite(SelectionKey key) throws IOException {
        ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
        byteBuffer.flip();
        SocketChannel socketChannel = (SocketChannel) key.channel();
        while (byteBuffer.hasRemaining()) {
            socketChannel.write(byteBuffer);
        }
        key.interestOps(SelectionKey.OP_READ);
        byteBuffer.compact();
    }

}
