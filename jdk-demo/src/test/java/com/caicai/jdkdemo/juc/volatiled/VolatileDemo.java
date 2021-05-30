package com.caicai.jdkdemo.juc.volatiled;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * 定义三步:
 * 1. 获取配置
 * 2. 使用配置
 */
public class VolatileDemo {

    Properties config;

    boolean initialized = false;

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo demo = new VolatileDemo();

        new Thread(() -> demo.readConfig()).start();
        new Thread(() -> {
            while (!demo.initialized) {
                demo.sleep(TimeUnit.MILLISECONDS, 1000L);
            }
            demo.config.forEach((k, v) -> {
                System.out.printf(" %s 区 - %s 小区 %s", k, v, System.lineSeparator());
            });
        }).start();

    }

    public void sleep(TimeUnit timeUnit, Long timeOut) {
        try {
            timeUnit.sleep(timeOut);
        } catch (InterruptedException e) {
        }
    }

    public void readConfig() {
        config = new Properties();
        sleep(TimeUnit.SECONDS, 1L);
        config.setProperty("青浦", "清水湾公寓");
        config.setProperty("南翔", "上隽嘉苑");
        config.setProperty("宝山", "宝欣苑一寸");
        initialized = true;
    }


}
