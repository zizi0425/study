package com.caicai.jdkdemo.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * JAVA 5之前; java类型使用Class
 * JAVA 5之后, 新增:
 * @see GenericArrayType  泛型数组类型 如: T[]
 * @see ParameterizedType 泛型参数类型 如:(T t)
 * @see TypeVariable      泛型类型变量 如:List<T>
 * @see WildcardType      泛型通配类型 如List<?>
 * 泛型api:
 * - 泛型信息: Class.getGenericInfo
 * - 泛型父类: Class.getGenericSuperclass
 * - 泛型接口: Class.getGenericSuperclass
 * - 泛型声明: Class.GenericDeclaration
 */
public class GenericApiDemo {

    /**
     * @see Type
     * These include raw types, parameterized types,
     * array types, type variables and primitive types.
     */
    @Test
    public void test() {
        //基本类型 1 primitive types
        Class<Integer> primitiveClass = int.class;
        //基本类型 2 array types
        Class<Object[]> arrayClass = Object[].class;
        //基本类型 3 raw types -> 没有泛型
        Class<String> rawClass = String.class;

        //泛型类型 1
//        Class gClass = ArrayList<E>.class;
        Class genericClass = ArrayList.class;
        ParameterizedType type = (ParameterizedType)genericClass.getGenericSuperclass();
        System.out.println("type = " + type);
        System.out.println("type.getRawType() = " + type.getRawType());
        System.out.println("type.getOwnerType() = " + type.getOwnerType());
        Arrays.stream(type.getActualTypeArguments()).forEach(System.out::println);
        Arrays.stream(type.getActualTypeArguments())
                .map(TypeVariable.class::cast)
                .forEach(typeVariable -> {
                    System.out.println("typeVariable.getBounds() = " + typeVariable.getBounds());
                });


        Type[] interfaces = genericClass.getGenericInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);


    }

}
