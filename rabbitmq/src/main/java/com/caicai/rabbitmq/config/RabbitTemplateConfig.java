package com.caicai.rabbitmq.config;

import com.caicai.rabbitmq.constant.BusinessConstant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: RabbitTemplateConfig
 * @Package: com.caicai.rabbitmq.config
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/14 16:13
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
public class RabbitTemplateConfig implements InitializingBean {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void afterPropertiesSet() throws Exception {
        rabbitTemplate.setBeforePublishPostProcessors(message -> {
            message.getMessageProperties().setHeader(BusinessConstant.TID, "abc");
            return message;
        });
    }
}
