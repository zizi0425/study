package com.caicai.springboot.core.reflect;


import org.junit.jupiter.api.Test;
import org.springframework.core.MethodParameter;
import org.springframework.core.ResolvableType;

/**
 * @see ResolvableType 替换了GenericTypeResolver和 GenericCollectionTypeResolver-
 * @see MethodParameter
 */
public class ResolveTypeDemo {


    @Test
    public void methodFor() {
        ResolvableType resolvableType = ResolvableType.forClass(GenericTypeResolverDemo.ListString.class);
        System.out.println("resolvableType.getSuperType() = " + resolvableType.getSuperType());
        System.out.println("resolvableType.asCollection() = " + resolvableType.asCollection());
        System.out.println("resolvableType.asCollection().getGeneric(0) = " + resolvableType.asCollection().getGeneric(0));
        System.out.println("resolvableType.asCollection().resolve() = " + resolvableType.asCollection().resolve());
        for (ResolvableType generic : resolvableType.asCollection().getGenerics()) {
            System.out.println("generic = " + generic);
        }
    }

    @Test
    public void TypeFor() {
        ResolvableType resolvableType = ResolvableType.forClass(String.class);
        Class<?> rawClass = resolvableType.getRawClass();
        if (rawClass == String.class) {
            System.out.println("\"true\" = " + "true");
        }
        System.out.println("resolvableType.getRawClass() = " + resolvableType.getRawClass());
    }


}
