package com.caicai.springboot.core.reflect;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Service;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: ResolvableTypeTest
 * @Package: com.caicai.springboot.core
 * @Description:
 * @author: yujie.wan
 * @date: 2021/2/4 11:00
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class ResolvableTypeTest {

    interface  A{

    }

    static class B {

    }
    @Data
    @Slf4j
    @Service
    static abstract class C extends B implements A, BeanDefinition {

    }

    @Test
    public void test() {
        ResolvableType resolvableType = ResolvableType.forClass(C.class);
        System.out.println("resolvableType.getComponentType() = " + resolvableType.getComponentType());
        for (ResolvableType generic : resolvableType.getGenerics()) {
            System.out.println("generic = " + generic);
        }
        for (ResolvableType anInterface : resolvableType.getInterfaces()) {

            System.out.println("anInterface = " + anInterface);
        }
        System.out.println("resolvableType.getSource() = " + resolvableType.getSource());
        System.out.println("resolvableType.getRawClass() = " + resolvableType.getRawClass());
        System.out.println("resolvableType.getSuperType() = " + resolvableType.getSuperType());
        System.out.println("resolvableType.getType() = " + resolvableType.getType());
    }
}
