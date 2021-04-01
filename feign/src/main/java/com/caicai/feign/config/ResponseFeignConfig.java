package com.caicai.feign.config;

import com.caicai.feign.entity.DemoResponse;
import feign.Feign;
import feign.Response;
import feign.codec.Decoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: ResponseFeignConfig
 * @Package: com.caicai.feign.config
 * @Description:
 * @author: yujie.wan
 * @date: 2021/3/30 13:55
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class ResponseFeignConfig {

    @Bean
    public Decoder decoder (){
        return new Decoder.Default() {
            @Override
            public Object decode(Response response, Type type) throws IOException {
                if (DemoResponse.class.equals(type)) {
                    DemoResponse demoResponse = new DemoResponse();
                    demoResponse.setCode(response.status());
                    demoResponse.setT(response.body().toString());
                }
                return super.decode(response, type);
            }
        };
    }


}
