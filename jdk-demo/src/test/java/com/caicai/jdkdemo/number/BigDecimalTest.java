package com.caicai.jdkdemo.number;

import java.math.BigDecimal;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: BigDecimalTest
 * @Package: com.caicai.jdkdemo.number
 * @Description:
 * @author: yujie.wan
 * @date: 2021/3/17 17:22
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal divide = new BigDecimal(100).divide(new BigDecimal(3), BigDecimal.ROUND_HALF_UP);
        System.out.println("divide = " + divide);
    }
}
