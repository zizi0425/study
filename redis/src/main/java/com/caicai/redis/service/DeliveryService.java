package com.caicai.redis.service;

import com.caicai.redis.entity.Delivery;
import com.caicai.redis.entity.RedisLockEntity;
import com.caicai.redis.extend.RedisLockExtend;
import com.caicai.redis.extend.RedisLockHelper;
import com.caicai.redis.redis.extend.DeliveryRedis;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: RedisService
 * @Package: com.caicai.redis.service
 * @Description:
 * @author: yujie.wan
 * @date: 2021/1/11 10:41
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Service
@Slf4j
public class DeliveryService {

    @Autowired
    DeliveryRedis deliveryRedis;

    public Delivery getFromRedis(String partnerId, String deliveryId) throws JsonProcessingException {
        return deliveryRedis.getValue(partnerId, deliveryId, Delivery.class);
    }

    public void delField(String partnerId, String deliveryId) {
        deliveryRedis.delField(partnerId,deliveryId);
    }

    @Autowired
    RedisLockHelper redisLockHelper;

    public void tryLock(Boolean flag) {
        redisLockHelper.execute(new RedisLockEntity("study.test.lock"), () -> {
            if (flag) {
                throw new RuntimeException("exception ...");
            } else {
                log.info("execute");
            }
        });
    }


}
