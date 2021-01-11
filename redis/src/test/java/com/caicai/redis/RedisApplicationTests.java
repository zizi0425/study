package com.caicai.redis;

import com.caicai.redis.entity.Delivery;
import com.caicai.redis.service.DeliveryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    DeliveryService deliveryService;

    @Test
    void contextLoads() throws JsonProcessingException {
        Delivery fromRedis = deliveryService.getFromRedis("9687", "123456");
        System.out.println("fromRedis = " + fromRedis);
    }

    @Test
    void delField() {
        deliveryService.delField("9687", "123456");
    }
}
