package com.caicai.jdkdemo.stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: ReduceTest
 * @Package: com.caicai.jdkdemo.stream
 * @Description:
 * @author: yujie.wan
 * @date: 2021/4/6 16:14
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class ReduceTest {

    @Test
    public void test1() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer integer = list.stream().reduce((a, b) -> a + b).orElse(0);
        System.out.println("integer = " + integer);
    }

    @Test
    public void test2() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer integer = list.stream().reduce(5, (a, b) -> a + b);
        System.out.println("integer = " + integer);

    }


}
