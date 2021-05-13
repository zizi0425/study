package com.caicai.springboot.beanFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: BeanFactoryDemo
 * @Package: com.caicai.springboot.beanFactory
 * @Description:
 * @author: yujie.wan
 * @date: 2021/3/22 10:37
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class BeanFactoryDemo {


    @Value("${custom.service:}")
    String[] customeService;

    public String[] allRouteServices() {
        //默认的
        String[] defaultServices = new String[]{
                "/FREEMUD-DELIVERY-DADA/**",
                "/FREEMUD-DELIVERY-SHUNFENG/**",
                "/FREEMUD-DELIVERY-DINGDING/**",
                "/FREEMUD-DELIVERY-CANTINGBAO/**"
        };
        if (customeService == null || customeService.length == 0) {
            return defaultServices;
        }
        String[] allServices = new String[defaultServices.length + customeService.length];
        //同Arrays.copy方法
        System.arraycopy(defaultServices, 0, allServices, 0, defaultServices.length);
        System.arraycopy(customeService, 0, allServices, defaultServices.length, customeService.length);
        return allServices;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanFactoryDemo.class);


        context.refresh();
        BeanFactoryDemo bean = context.getBean(BeanFactoryDemo.class);
        Stream.of(bean.allRouteServices()).forEach(System.out::println);

        context.close();

    }
}
