package com.caicai.rabbitmq.config;

import com.caicai.rabbitmq.constant.MQConstant;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: DeclareConfig
 * @Package: com.caicai.rabbitmq.config
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/14 13:58
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
public class DeclareConfig implements InitializingBean {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Override
    public void afterPropertiesSet() throws Exception {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        Exchange exchange = new DirectExchange(MQConstant.TestQueue.TEST_EXCHANGE);
        rabbitAdmin.declareExchange(exchange);
        Queue queue = new Queue(MQConstant.TestQueue.TEST_QUEUE);
        rabbitAdmin.declareQueue(queue);
        Binding binding = BindingBuilder.bind(queue)
                .to(exchange)
                .with(MQConstant.TestQueue.TEST_ROUTING)
                .noargs();
        rabbitAdmin.declareBinding(binding);
    }
}
