package com.caicai.caffiene;

//import com.github.benmanes.caffeine.cache.Cache;
//import com.github.benmanes.caffeine.cache.Caffeine;
//import org.springframework.cache.caffeine.CaffeineCacheManager;
//
//import java.util.ArrayList;
//import java.util.concurrent.TimeUnit;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: CacheManagerDemo
 * @Package: com.caicai.caffiene
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/20 10:33
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class CacheManagerDemo {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(CacheManagerDemo.class, CacheConfig.class);

        applicationContext.refresh();
        CacheUtils.put(CacheEnum.CITY,"嘉定", "上海");
        CacheUtils.put(CacheEnum.CITY,"浦东", "上海");
        CacheUtils.put(CacheEnum.CITY,"宝山", "上海");
        CacheUtils.put(CacheEnum.CITY,"黄埔", "上海");
        CacheUtils.put(CacheEnum.CITY,"青浦", "上海");

        System.out.println(CacheUtils.getValue(CacheEnum.CITY, "青浦", String.class));
        Collection<String> allValue = CacheUtils.getAllValue(CacheEnum.CITY, String.class);
        allValue.forEach(System.out::println);

        TimeUnit.SECONDS.sleep(6);

        Collection<String> allValue1 = CacheUtils.getAllValue(CacheEnum.CITY, String.class);
        allValue1.forEach(System.out::println);
        applicationContext.close();
    }



}
