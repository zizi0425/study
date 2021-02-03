package com.caicai.retry.support;

import com.caicai.retry.entity.RetryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: RetrySupport
 * @Package: com.caicai.retry.support
 * @Description:
 * @author: yujie.wan
 * @date: 2021/2/3 10:32
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
public class RetrySupport {

    private static RestTemplate restTemplate;

    private static RetryTemplate retryTemplate;

    private volatile Boolean isRunning = false;

    private static final String CUSTOM_ATTR = "custom_attr";

    private Queue<RetryEntity> retryEntities = new LinkedBlockingDeque<>();

    private static Integer count = 0;

    static {
        retryTemplate = new RetryTemplate();
        restTemplate = new RestTemplate();
    }

    public void retry(RetryEntity retryEntity) {
        retryEntities.offer(retryEntity);
        if (isRunning == true) {
            return;
        }
        isRunning = true;
        new Thread(() -> {
            System.out.println("Thread Name" + Thread.currentThread().getName() + "current Count" + retryEntities.size());
            while (true) {
                RetryEntity poll = retryEntities.poll();
                if (poll == null) {
                    isRunning = false;
                    return;
                }
                String execute = execute(poll);
                count += 1;
                System.out.println("execute = " + execute);
            }
        }).start();
    }

    public String execute(RetryEntity retryEntity) {
        return retryTemplate.execute(context -> {
            String url = retryEntity.getUrl();
            Object attribute = context.getAttribute(CUSTOM_ATTR);
            if (attribute == null) {
                attribute = 0;
            }
            context.setAttribute(CUSTOM_ATTR, (Integer) attribute + 1);
            String object = restTemplate.postForObject(url, retryEntity.getT(), String.class);
            return object;
        }, context -> {
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            return "重试了三次" + context.getAttribute(CUSTOM_ATTR);});
    }



}
