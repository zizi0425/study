package com.caicai.feign.simple;

import com.caicai.feign.simple.client.BaiDuClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: FeignClientDefaultMethodDemo
 * @Package: com.caicai.feign.simple
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/21 14:29
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@EnableFeignClients(clients = BaiDuClient.class)
public class FeignClientDefaultMethodDemo {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(FeignClientDefaultMethodDemo.class, FeignAutoConfiguration.class);
        applicationContext.refresh();

        BaiDuClient bean = applicationContext.getBean(BaiDuClient.class);
        System.out.println("bean.get() = " + bean.get());
        applicationContext.close();

    }

}
