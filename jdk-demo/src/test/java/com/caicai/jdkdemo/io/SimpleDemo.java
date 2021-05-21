package com.caicai.jdkdemo.io;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: ChannelDemo
 * @Package: com.caicai.jdkdemo.io
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/18 17:32
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class SimpleDemo {

   static String fileName = "C:/Users/yujie.wan/Desktop/app接口以及入参示例.md";


    /**
     * http://ifeve.com/channels/
     * FileChannel 从文件中读取
     * DatagramChannel UDP读取数据
     * SocketChannel TCP
     * ServerSocketChannel 监听TCP连接; 对每一个连接都会创建一个SocketChannel
     * @throws IOException
     */
    @Test
    public void channel() throws IOException {
        RandomAccessFile file = new RandomAccessFile(fileName, "rw");
        FileChannel channel = file.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(512);
        int read = channel.read(buf);
        while (read != -1) {
            buf.flip();
            byte[] bytes = new byte[read];
            int index = 0;
            while (buf.hasRemaining()) {
                bytes[index] = buf.get();
                index++;
            }
            String s = new String(bytes, "utf-8");
            System.out.println("s = " + s);
            buf.clear();
            read = channel.read(buf);
        }
        file.close();
    }


    /**
     * http://ifeve.com/buffers/
     * 缓存去本质上就是一块可以写入可以读取的内存; 这块内存被包装成了NIO Buffer对象
     * 使用buffer读写一般遵循的四个步骤
     * - 1.写入buffer
     * - 2.调用flip方法
     * - 3.读取数据
     * - 4.清空缓存
     *      - clear() 清空整个缓冲区
     *      - compact() 清空已经读取过的数据
     */
    @Test
    public void buffer() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(fileName));
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        //放入缓冲区
        int read = channel.read(byteBuffer);
        while (read != -1) {
            //使用buffer前先切换为读取状态
            byteBuffer.flip();
            byte[] bytes = new byte[read];
            int index = 0;
            while (byteBuffer.hasRemaining()) {
                //去除数据
                bytes[index++] = byteBuffer.get();
            }
            String body = new String(bytes, "utf-8");
            System.out.println("body = " + body);
            //清空使用过的缓冲区数据
            byteBuffer.compact();
            //重新读数据
            read = channel.read(byteBuffer);
        }
        fileInputStream.close();
    }

    @Test
    public void transfer() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(fileName));
        FileChannel inputStreamChannel = fileInputStream.getChannel();

        RandomAccessFile accessFile = new RandomAccessFile("C:/Users/yujie.wan/Desktop/app接口以及入参示例-2.md", "rw");
        FileChannel channel = accessFile.getChannel();

        long size = inputStreamChannel.size();
        channel.transferFrom(inputStreamChannel, 0, size);
    }

    /**
     * 传统id
     * https://blog.csdn.net/forezp/article/details/88414741/
     * @throws IOException
     */
    @Test
    public void tradition() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             BufferedInputStream inputStream = new BufferedInputStream(fileInputStream)) {
            read(inputStream);
        }
    }

    @Test
    public void nio() throws IOException {
        try (RandomAccessFile accessFile = new RandomAccessFile(fileName, "rw");
             FileChannel fileChannel = accessFile.getChannel()) {
            read(fileChannel);
        }
    }


    public static void read(ByteChannel channel) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int read = channel.read(byteBuffer);
        while (read != -1) {
            byte[] bytes = new byte[1024];
            int index = 0;
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                bytes[index++] = byteBuffer.get();
            }
            String s = new String(bytes, "utf-8");
            System.out.println("s = " + s);
            byteBuffer.clear();
            read = channel.read(byteBuffer);
        }
    }




    public static void read(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int read = inputStream.read(buffer);
        while (read != -1) {
            String s = new String(buffer, "utf-8");
            System.out.println("s = " + s);
            read = inputStream.read(buffer);
        }
    }

}
