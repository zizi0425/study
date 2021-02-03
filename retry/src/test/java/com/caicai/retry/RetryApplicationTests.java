package com.caicai.retry;

import com.caicai.retry.entity.RetryEntity;
import com.caicai.retry.support.RetrySupport;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

@SpringBootTest
class RetryApplicationTests {

    @Autowired
    RetrySupport retrySupport;

    @Test
    void contextLoads() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10000; i++) {
            executorService.execute(()->{
                RetryEntity retryEntity = createRetryEntity();
                retrySupport.retry(retryEntity);
            });
        }
        TimeUnit.SECONDS.sleep(20);
    }

    @Test
    void retryTest2() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 5, 60, TimeUnit.SECONDS,
                new SynchronousQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 1000; i++) {
            threadPoolExecutor.execute(()->{
                retrySupport.execute(createRetryEntity());
            });
        }
        threadPoolExecutor.shutdown();
        TimeUnit.SECONDS.sleep(20);
    }


    //huididao

    @Test
    void retryTest3() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1, 5, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 1000; i++) {
            threadPoolExecutor.execute(()->{
                retrySupport.execute(createRetryEntity());
            });
        }
        threadPoolExecutor.shutdown();
        TimeUnit.SECONDS.sleep(20);
    }


    public static RetryEntity createRetryEntity() {
        RetryEntity retryEntity = new RetryEntity();
        retryEntity.setUrl("freemud-delivery-service-koderover-dev-delivery-service.api-ingress.sandload.cn/delivery/getDeliveryStatusAndRiderPosition");
        Demo demo = new Demo();
        demo.setDeliveryId("198609725217175045");
        demo.setOpenDistance("1");
        retryEntity.setT(demo);
        return retryEntity;
    }
    @Data
    static class Demo {
        String deliveryId;
        String openDistance;
    }

}
