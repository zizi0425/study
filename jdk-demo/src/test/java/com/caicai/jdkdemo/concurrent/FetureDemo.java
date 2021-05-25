package com.caicai.jdkdemo.concurrent;

import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.concurrent.*;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: FetureDemo
 * @Package: com.caicai.jdkdemo.concurrent
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/24 11:36
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class FetureDemo {

    static Callable<String> callable = () -> {
        TimeUnit.SECONDS.sleep(2);
        return UUID.randomUUID().toString();
    };

    @Test
    public void callTest() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<String> future1 = executorService.submit(callable);
        Future<String> future2 = executorService.submit(callable);

        String f1 = future1.get();
        String f2 = future2.get();
        System.out.printf("f1 = " + f1);
        System.out.println("f2 = " + f2);

        executorService.shutdown();
    }


    @Test
    public void completeFetureTest() throws ExecutionException, InterruptedException {
        CompletableFuture completableFuture = new CompletableFuture();
        completableFuture.complete(UUID.randomUUID().toString());
        boolean complete = completableFuture.complete(100);
        System.out.println("completableFuture.get() = " + completableFuture.get());
        System.out.println("complete = " + complete);
    }



}
