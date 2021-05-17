package com.caicai.rabbitmq.controller;

import com.caicai.rabbitmq.constant.MQConstant;
import com.caicai.rabbitmq.entity.TestMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: TestController
 * @Package: com.caicai.rabbitmq.Controller
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/14 14:35
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@RestController
public class TestController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/send/{body}")
    public ResponseEntity<String> send(@PathVariable String body) {
        TestMessage testMessage = new TestMessage();
        testMessage.setBody(body);
        rabbitTemplate.convertAndSend(MQConstant.TestQueue.TEST_EXCHANGE,
                MQConstant.TestQueue.TEST_ROUTING,
                testMessage);
        return ResponseEntity.ok("success");
    }
}
