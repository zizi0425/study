package com.caicai.redis.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: RedisHash
 * @Package: com.caicai.redis.redis
 * @Description:
 * @author: yujie.wan
 * @date: 2021/1/11 9:59
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */

public abstract class RedisHash<T> {

    @Autowired
    protected StringRedisTemplate redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    protected Integer expire = 1;

    protected TimeUnit timeUnit = TimeUnit.DAYS;

    protected String baseKey = "";

    protected String baseField = "";


    public T getValue(String key, String field, Class<T> tClass) throws JsonProcessingException {
        String redisKey = baseKey + key;
        String redisField = baseField + field;
        Object redisValue = redisTemplate.opsForHash().get(redisKey, redisField);
        if (Objects.nonNull(redisValue)) {
            return objectMapper.readValue(redisValue.toString(), tClass);
        }
        Boolean existKey = redisTemplate.hasKey(redisKey);

        T t = this.searchDB(key, field);
        redisTemplate.opsForHash().put(redisKey, redisField, objectMapper.writeValueAsString(t));
        if (!existKey) {
            redisTemplate.expire(redisKey, expire, timeUnit);
        }
        return t;
    }

    public void delKey(String key) {
        redisTemplate.delete(baseKey + key);
    }

    public void delField(String key, String field) {
        redisTemplate.opsForHash().delete(baseKey + key, baseField + field);
    }

    protected abstract T searchDB(String key,String field);


}
