package com.caicai.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: LoggerFeignConfig
 * @Package: com.caicai.feign.config
 * @Description:
 * @author: yujie.wan
 * @date: 2021/3/30 11:23
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class LoggerFeignConfig {

    @Bean
    Logger.Level fullLevel() {
        return Logger.Level.FULL;
    }

}
