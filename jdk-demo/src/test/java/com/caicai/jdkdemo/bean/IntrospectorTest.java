package com.caicai.jdkdemo.bean;

import com.alibaba.fastjson.JSONObject;
import com.caicai.entity.Person;
import org.junit.jupiter.api.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: IntrospectorTest
 * @Package: com.caicai.jdkdemo.bean
 * @Description:
 * @author: yujie.wan
 * @date: 2021/1/12 19:20
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class IntrospectorTest {

    @Test
    public void propertyDescriptor() throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
        System.out.println("beanInfo.getPropertyDescriptors() = " + beanInfo.getPropertyDescriptors());
        System.out.println("beanInfo.getMethodDescriptors() = " + beanInfo.getMethodDescriptors());
    }


    @Test
    public void test() {
        String str = "abc";

        String s = JSONObject.parseObject(str, String.class);
        System.out.println("s = " + s);
    }
}
