package com.caicai.caffiene;

import lombok.Getter;
import org.springframework.util.ObjectUtils;

import java.time.Duration;

@Getter
public enum CacheEnum {

    CITY("dada_city", 100000, Duration.ofSeconds(5)),

    ;


    private String cacheName;

    private Integer cacheSize;

    private Duration duration;

    CacheEnum(String cacheName, Integer cacheSize, Duration duration) {
        this.cacheName = cacheName;
        this.cacheSize = cacheSize;
        this.duration = duration;
    }


    public static CacheEnum getByCacheName(String cahceName) {
        for (CacheEnum value : values()) {
            if (ObjectUtils.nullSafeEquals(cahceName, value.cacheName)) {
                return value;
            }
        }
        return null;
    }

}
