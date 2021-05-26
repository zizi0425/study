package com.caicai.springboot.beanFactory.fulllite;

import com.caicai.springboot.beanFactory.entity.Person;
import com.caicai.springboot.beanFactory.entity.School;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: FullLiteDemo
 * @Package: com.caicai.springboot.beanFactory
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/25 17:24
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class FullLiteDemo {

    /**
     * {@link Configuration} 标注的类除了自己是一个bean组件外; 还有一层语义是作为bean定义的源;
     * 允许通过调用同一个类的其他 @Bean 方法来定义bean之间的依赖关系
     * 如果{@link Configuration}内的bean之间没有互相引用; 则可以通过设置proxyBeanMethods来提升性能(不创建代理类)
     * @param args
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.caicai.springboot.beanFactory.fulllite");

        applicationContext.refresh();

//        personConfigTest(applicationContext);
        PersonBeanTest(applicationContext);

        applicationContext.close();

    }

    static void PersonBeanTest(AnnotationConfigApplicationContext applicationContext) {
        PersonBean bean = applicationContext.getBean(PersonBean.class);
        School bean1 = applicationContext.getBean(School.class);
        System.out.println(bean1);
        System.out.println("bean.school() = " + bean.school());
    }

    private static void personConfigTest(AnnotationConfigApplicationContext applicationContext) {
        PersonConfig bean = applicationContext.getBean(PersonConfig.class);
        System.out.println("bean.person() = " + bean.person());
        PersonConfig bean2 = applicationContext.getBean(PersonConfig.class);
        System.out.println("bean2.person() = " + bean2.person());
    }


}
