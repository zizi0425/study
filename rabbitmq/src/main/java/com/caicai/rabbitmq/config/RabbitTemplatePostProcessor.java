package com.caicai.rabbitmq.config;

import com.caicai.rabbitmq.constant.BusinessConstant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: RabbitTemplatePostProcessor
 * @Package: com.caicai.rabbitmq.config
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/17 17:27
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
public class RabbitTemplatePostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (RabbitTemplate.class.equals(bean.getClass())) {
            RabbitTemplate rabbitTemplate = (RabbitTemplate) bean;
            rabbitTemplate.setBeforePublishPostProcessors(message -> {
                message.getMessageProperties().setHeader(BusinessConstant.TID, "abc");
                return message;
            });
        }
        return false;
    }
}
