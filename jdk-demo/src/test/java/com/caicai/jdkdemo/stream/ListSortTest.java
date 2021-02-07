package com.caicai.jdkdemo.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: ListSortTest
 * @Package: com.caicai.jdkdemo.stream
 * @Description:
 * @author: yujie.wan
 * @date: 2021/2/5 15:59
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class ListSortTest {

    @Data
    @AllArgsConstructor
    @ToString
    class A{
        Date birthday;
    }

    @Test
    public void test() {
        List<A> list = new ArrayList<>();
        long l = System.currentTimeMillis();
        list.add(new A(random(l)));
        list.add(new A(random(l)));
        list.add(new A(random(l)));
        list.add(new A(random(l)));
        list.add(new A(random(l)));
        list.add(new A(random(l)));
        list.add(new A(random(l)));
        list.stream()
                .sorted(Comparator.comparing(A::getBirthday).reversed())
                .forEach(
                        System.out::println
                );
    }

    static Random random = new Random();
    public static Date random(Long currentTime){
        int i = random.nextInt(100000);
        return new Date(currentTime - i);
    }

}
