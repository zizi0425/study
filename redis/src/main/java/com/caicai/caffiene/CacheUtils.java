package com.caicai.caffiene;

import org.springframework.beans.BeansException;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: CacheUtils
 * @Package: com.freemud.delivery.dada.util
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/20 14:17
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class CacheUtils implements ApplicationContextAware {

    private static CacheManager cacheManager;

    public static Cache getCache(CacheEnum cacheEnum) {
        return cacheManager.getCache(cacheEnum.getCacheName());
    }

    public static <T> T getValue(CacheEnum cacheEnum, String cacheKey, Class<T> tClass) {
        return getCache(cacheEnum).get(cacheKey, tClass);
    }

    public static <T> Collection<T> getAllValue(CacheEnum cacheEnum, Class<T> tClass) {
        com.github.benmanes.caffeine.cache.Cache cache = (com.github.benmanes.caffeine.cache.Cache) getCache(cacheEnum)
                .getNativeCache();
        Collection values = cache.asMap().values();
        return (Collection<T>) values;
    }
    public static void put(CacheEnum cacheEnum, String cacheKey, Object value) {
        getCache(cacheEnum).put(cacheKey, value);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        cacheManager = applicationContext.getBean(CacheManager.class);
    }
}
