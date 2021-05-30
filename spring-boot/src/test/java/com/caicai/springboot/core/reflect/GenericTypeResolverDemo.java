package com.caicai.springboot.core.reflect;

import org.junit.jupiter.api.Test;
import org.springframework.core.GenericTypeResolver;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * spring中 泛型处理的辅助类
 * @see GenericTypeResolver
 * 处理类型相关方法
 *   resolveReturnType
 *   resolveType
 * 处理泛型参数类型(ParameterizedType)相关方法
 *   resolveReturnTypeArgument
 *   resolveTypeArgument
 *   resolveTypeArguments
 * 处理泛型类型变量(TypeVarivble)相关方法
 *   getTypeVariableMap
 */
public class GenericTypeResolverDemo {


    public static String get() {
        return null;
    }

    public static <E> List<E> list() {
        return null;
    }
    public static ListString listString() {
        return null;
    }


    @Test
    public void typeTest() throws NoSuchMethodException {
        display(GenericTypeResolverDemo.class, "get");
        display(GenericTypeResolverDemo.class, "list");
        display(GenericTypeResolverDemo.class, "listString");
        //一旦泛型固定; 那么TypeVariable就会存在
        Map<TypeVariable, Type> typeVariableMap = GenericTypeResolver.getTypeVariableMap(ListString.class);
        System.out.println("typeVariableMap = " + typeVariableMap);
    }

    public static void display(Class clazz, String methodName, Class... param) throws NoSuchMethodException {
        Method method = clazz.getMethod(methodName, param);
        Class<?> aClass = GenericTypeResolver.resolveReturnType(method, clazz);
        //如果当前类支持泛型; resolveReturnTypeArgument的参数可以是aClass; 如果当前没有泛型; 则返回null
        Class<?> aClass1 = GenericTypeResolver.resolveReturnTypeArgument(method, List.class);
        System.out.println("GenericTypeResolver.resolveReturnType = " + aClass);
        System.out.println("GenericTypeResolver.resolveReturnTypeArgument = " + aClass1);
    }


    static class ListString extends ArrayList<String> {
    }


}
