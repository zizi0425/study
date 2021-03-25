package com.caicai.feign.config;

import feign.*;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Enumeration;
import java.util.UUID;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: BaseFeignConfig
 * @Package: com.caicai.feign.config
 * @Description:
 * @author: yujie.wan
 * @date: 2021/2/22 10:55
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Configuration
public class BaseFeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }


    @Bean
    public RequestInterceptor requestInterceptor() {
        return (RequestTemplate requestTemplate) -> {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            String logId = request.getHeader("logId");
            String token = request.getHeader("token");
            Enumeration<String> headerNames = request.getHeaderNames();
            if (headerNames != null) {
                while (true) {
                    if (!headerNames.hasMoreElements()) {
                        if (logId == null) {
                            requestTemplate.header("logId", new String[]{DigestUtils.md5DigestAsHex(UUID.randomUUID().toString().getBytes())});
                        }

                        if (StringUtils.isEmpty(token)) {
                            token = request.getParameter("token");
                            requestTemplate.header("token", new String[]{"e16acfd5dcde9c8c3fd2005e29c609d4"});
                        }
                        break;
                    }

                    String name = (String) headerNames.nextElement();
                    String values = request.getHeader(name);
                    requestTemplate.header(name, new String[]{values});
                }
            }

        };
    }
}
