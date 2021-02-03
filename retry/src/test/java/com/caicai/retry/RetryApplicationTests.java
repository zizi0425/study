package com.caicai.retry;

import com.caicai.retry.entity.RetryEntity;
import com.caicai.retry.support.RetrySupport;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        Thread.sleep(33333);
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
