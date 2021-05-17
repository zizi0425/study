package com.caicai.rabbitmq.consumer;

import com.caicai.rabbitmq.constant.MQConstant;
import com.caicai.rabbitmq.entity.TestMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.caicai.rabbitmq.constant.BusinessConstant.TID;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: TestConsumer
 * @Package: com.caicai.rabbitmq.consumer
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/14 13:48
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
@Slf4j
public class TestConsumer {


    @RabbitListener(queues = MQConstant.TestQueue.TEST_QUEUE)
    public void execute(Message testMessage) {
        System.out.println("testMessage.getHeaders().get(\"abc\") = " + testMessage.getHeaders().get("abc"));
        System.out.println("testMessage.getPayload() = " + testMessage.getPayload());
    }


    @RabbitListener(queues = MQConstant.TestQueue.TEST_QUEUE)
    public void execute1(@Payload TestMessage testMessage, @Header(name = TID,required = false) String abc) {
        System.out.println("abc = " + abc);
        System.out.println("testMessage = " + testMessage);
    }

}
