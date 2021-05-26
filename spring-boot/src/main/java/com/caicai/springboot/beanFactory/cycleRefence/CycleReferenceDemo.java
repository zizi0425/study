package com.caicai.springboot.beanFactory.cycleRefence;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: CiycleReferenceDemo
 * @Package: com.caicai.springboot.beanFactory
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/26 13:59
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class CycleReferenceDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(CycleReferenceDemo.class);
        applicationContext.refresh();

        applicationContext.close();
    }



    @Bean
    private A a(){
        return new A();
    }
    @Bean
    private B b(){
        return new B();
    }
    @Bean
    private C c(){
        return new C();
    }


}
