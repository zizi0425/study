package com.caicai.jdkdemo.number;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: NumberFormatTest
 * @Package: com.caicai.jdkdemo.number
 * @Description:
 * @author: yujie.wan
 * @date: 2021/4/12 10:41
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class NumberFormatTest {


    @Test
    public void test1() {
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        Integer i = 399;
        Integer j = 200;
        System.out.println("percentInstance.format(j/i) = " + percentInstance.format((double)j / i));
        Long startTime = new Long(-8000);
        System.out.println("(startTime <= 0L) = " + (startTime <= 0L));
    }

    @Test
    public void test2() {
        System.out.println("(255L % 2 == 0) = " + (0L % 20));
    }
}
