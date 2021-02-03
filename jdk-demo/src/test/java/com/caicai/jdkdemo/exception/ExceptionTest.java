package com.caicai.jdkdemo.exception;

import org.junit.jupiter.api.Test;

import java.net.SocketTimeoutException;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: ExceptionTest
 * @Package: com.caicai.jdkdemo.exception
 * @Description:
 * @author: yujie.wan
 * @date: 2021/2/2 9:50
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class ExceptionTest
{

    @Test
    public void testPrint() {
        try {
            throw new SocketTimeoutException("chaoshi");
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            System.out.println("e.getClass() = " + e.getClass());
            System.out.println("e.getCause() = " + e.getCause());
            System.out.println("e.getLocalizedMessage() = " + e.getLocalizedMessage());
            System.out.println("e.getStackTrace() = " + e.getStackTrace());
            System.out.println("e.getSuppressed() = " + e.getSuppressed());
        }
    }
}
