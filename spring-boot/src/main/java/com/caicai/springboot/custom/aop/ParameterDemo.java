package com.caicai.springboot.custom.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: ParameterDemo
 * @Package: com.caicai.springboot.custom.aop
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/13 16:12
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@EnableAspectJAutoProxy
public class ParameterDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ParameterDemo.class, AspectConfiguration.class);
        context.refresh();

        ParameterDemo demo = context.getBean(ParameterDemo.class);
        demo.execute("123", "345");
        context.close();
    }


    public void execute(String arg1, @RequestParam String arg2) {
        System.out.println("execute()...");
    }
}
