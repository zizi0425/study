package com.caicai.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.listener.RetryListenerSupport;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: RetryConfig
 * @Package: com.caicai.retry
 * @Description:
 * @author: yujie.wan
 * @date: 2021/2/3 14:15
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Configuration
@Slf4j
public class RetryConfig {

    private static String PRINT_CONTEXT = "print.context";

    /**
     * 日志打印基本listener
     * @return
     */
    @Bean
    public RetryListenerSupport retryListenerSupport() {
        return new RetryListenerSupport() {
            @Override
            public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
                Object printContext = context.getAttribute(PRINT_CONTEXT);
                Object label = context.getAttribute(RetryContext.NAME);
                int retryCount = context.getRetryCount();
                log.error("{} 重试发生异常, 重试第: {} 次, 打印内容: {} ", label, retryCount, printContext);
            }
        };
    }



}
