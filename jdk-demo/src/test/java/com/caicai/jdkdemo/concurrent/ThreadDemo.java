package com.caicai.jdkdemo.concurrent;

import com.caicai.jdkdemo.concurrent.entity.SynchronizedTaskQueue;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: ThreadDemo
 * @Package: com.caicai.jdkdemo.concurrent
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/24 15:36
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class ThreadDemo {

    public static void sleep(Duration duration) {
        try {
            TimeUnit.MILLISECONDS.sleep(duration.toMillis());
        } catch (InterruptedException e) {
            currentThread().interrupt();
        }
    }

    /**
     * thread.join会让线程执行完再继续运行
     * @throws InterruptedException
     */
    @Test
    public void threadTest() throws InterruptedException {
        Thread thread = new Thread(() -> {
            sleep(Duration.ofSeconds(2));
            System.out.println("hello");
        });
        thread.start();
        thread.join();
        System.out.println("over");
    }


    /**
     * interrupt() 只是发送了中断请求, 具体是否能响应,需要看具体代码
     * @throws InterruptedException
     */
    @Test
    public void interruptTest() throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.printf("当前线程: %s ,当前时间:%s \n", currentThread().getName(), LocalTime.now());
            sleep(Duration.ofSeconds(5));
            System.out.printf("当前线程: %s ,当前状态:%s\n", currentThread().getName(), currentThread().isInterrupted());

            while (!currentThread().isInterrupted()) {
                sleep(Duration.ofSeconds(1));
                System.out.println("hello");
            }
        });
        t.start();
        System.out.printf("当前线程: %s ,当前时间:%s \n", currentThread().getName(), LocalTime.now());
        sleep(Duration.ofSeconds(1));
        t.interrupt();
        t.join();
        System.out.println("end");
    }

    @Test
    public void interruptTest2() throws InterruptedException {
        Thread thread = new Thread(() -> {
            Thread sub = new Thread(() -> {
                while (!currentThread().isInterrupted()) {
                    sleep(Duration.ofSeconds(1));
                    System.out.printf("当前线程: %s ,当前时间:%s \n", currentThread().getName(), LocalTime.now());
                }
            });
            sub.start();
            try {
                sub.join();
            } catch (InterruptedException e) {
                System.out.printf("当前线程中断: %s ,当前时间:%s \n", currentThread().getName(), LocalTime.now());
            }
            sub.interrupt();
        });
        thread.start();
        sleep(Duration.ofSeconds(3));
        thread.interrupt();
        thread.join();
        System.out.println("end");
    }

    /**
     * wait 阻塞 释放锁
     * notify后会重新进行就绪
     * @throws InterruptedException
     */
    @Test
    public void waitAndNotify() throws InterruptedException {
        SynchronizedTaskQueue synchronizedTaskQueue = new SynchronizedTaskQueue();

        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    try {
                        String task = synchronizedTaskQueue.getTask();
                        System.out.printf("threadName: %s , taskN: %s\n", currentThread().getName(), task);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            });
            thread.start();
            list.add(thread);
        }

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String task = "t-" + Math.random();
                synchronizedTaskQueue.addTask(task);
                sleep(Duration.ofSeconds(1));
            }
        });
        thread.start();
        thread.join();
        sleep(Duration.ofSeconds(4));
        //主线程已经执行完了; 但是这几个月线程while无限循环不会退出;
        for (Thread thread1 : list) {
            thread1.interrupt();
        }
    }








}
