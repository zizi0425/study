package com.caicai.redis.exception;

import com.caicai.redis.util.RedisLockUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: ExceptionTest
 * @Package: com.caicai.redis.exception
 * @Description:
 * @author: yujie.wan
 * @date: 2021/1/29 9:41
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Slf4j
public class ExceptionTest {

    @Test
    public void tryCatchTest() {
        log.info("当前线程:{} ", Thread.currentThread().getName());
        new RedisLockUtils("333", 3L, () -> {
            log.info("当前线程:{} ", Thread.currentThread().getName());
            throw new RuntimeException("3333");
        }).execute();
        log.info("当前线程:{} ", Thread.currentThread().getName());
    }
}
