package com.caicai.jdkdemo.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: ParameterizedTypeTest
 * @Package: com.caicai.jdkdemo.reflect
 * @Description:
 * @author: yujie.wan
 * @date: 2021/4/2 15:16
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class ParameterizedTypeTest {

    @Test
    public void test() {
        Field[] declaredFields = B.class.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("field.getAnnotatedType() = " + field.getAnnotatedType());
            System.out.println("field.getGenericType() = " + field.getGenericType());
            if (field.getGenericType() instanceof ParameterizedType) {
                ParameterizedType type = (ParameterizedType) field.getGenericType();
                System.out.println("type.getActualTypeArguments() = " + type.getActualTypeArguments());
                System.out.println("type.getOwnerType() = " + type.getOwnerType());
                System.out.println("type.getRawType() = " + type.getRawType());
                System.out.println("type.getTypeName() = " + type.getTypeName());
                System.out.println("type.getClass().getName() = " + type.getClass().getName());
            }
            System.out.println("\"-------\" = " + "-------");
        }
    }

    static class B{
        List<String> list;
        String string;
        Map<String, String> map;
        List list2;
    }
}
