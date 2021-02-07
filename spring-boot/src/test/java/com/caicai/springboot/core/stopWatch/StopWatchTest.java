package com.caicai.springboot.core.stopWatch;

import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: StopWatchTest
 * @Package: com.caicai.springboot.core.stopWatch
 * @Description:
 * @author: yujie.wan
 * @date: 2021/2/4 16:33
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class StopWatchTest {

    @Test
    public void test() throws InterruptedException {
        StopWatch stopWatch = new StopWatch("test");
        stopWatch.start("task1");
        stopWatch.stop();
        stopWatch.start("task2");
        stopWatch.stop();
        stopWatch.start("task3");
        stopWatch.stop();
    }

    @Test
    public void test2() throws InterruptedException {
        org.apache.commons.lang3.time.StopWatch stopWatch = new org.apache.commons.lang3.time.StopWatch();
        stopWatch.start();
        TimeUnit.SECONDS.sleep(1);
        stopWatch.stop();
        System.out.println("stopWatch.getMessage() = " + stopWatch.getMessage());
        System.out.println("stopWatch.getStartTime() = " + stopWatch.getStartTime());
        System.out.println("stopWatch.getTime() = " + stopWatch.getTime());
        System.out.println("stopWatch.formatTime() = " + stopWatch.formatTime());
        System.out.println("stopWatch.toString() = " + stopWatch.toString());
    }
}
