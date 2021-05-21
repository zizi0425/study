package com.caicai.caffiene;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: CacheConfig
 * @Package: com.freemud.delivery.dada.config
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/20 11:24
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Slf4j
public class CacheConfig {


    @Bean
    public CacheUtils cacheUtils() {
        return new CacheUtils();
    }

    @Bean
    public CacheManager cacheManager() {
       return new CaffeineCacheManager() {
            @Override
            protected Cache<Object, Object> createNativeCaffeineCache(String name) {
                CacheEnum cacheEnum = CacheEnum.getByCacheName(name);
                log.error("process cache init, cacheName:{} , duration: {}", cacheEnum.getCacheName(), cacheEnum.getDuration());
                return Caffeine.newBuilder()
                        .maximumSize(cacheEnum.getCacheSize())
                        .expireAfterWrite(cacheEnum.getDuration())
                        .build();
            }
        };
    }

}
