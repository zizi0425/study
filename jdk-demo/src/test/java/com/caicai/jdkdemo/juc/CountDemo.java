package com.caicai.jdkdemo.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class CountDemo {
    private static int threadCount = 200;
    private static int clientTotal = 5000;
    private static long count = 0;

    /**
     * 模拟的场景为;
     * 客户端发送出5000请求
     * 200个用户;
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadCount);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {

                }
            });
        }
        System.out.println("count = " + count);
    }


    public static void add() {
        count++;
    }
}
