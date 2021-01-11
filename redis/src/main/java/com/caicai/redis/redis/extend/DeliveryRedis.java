package com.caicai.redis.redis.extend;

import com.caicai.redis.entity.Delivery;
import com.caicai.redis.redis.RedisHash;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: DeliveryRedis
 * @Package: com.caicai.redis.redis.extend
 * @Description:
 * @author: yujie.wan
 * @date: 2021/1/11 10:43
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
public class DeliveryRedis extends RedisHash<Delivery> {

    protected String baseKey = "fids:test:delivery:";

    protected String baseField = "";

    @Override
    protected Delivery searchDB(String key, String field) {
        Delivery delivery = new Delivery();
        delivery.setChannel(String.valueOf(System.currentTimeMillis()));
        delivery.setDeliveryId(field.toString());
        return delivery;
    }

}
