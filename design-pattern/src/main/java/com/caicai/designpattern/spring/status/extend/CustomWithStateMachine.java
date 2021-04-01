package com.caicai.designpattern.spring.status.extend;

import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.EventHeaders;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.OnTransitionStart;
import org.springframework.statemachine.annotation.WithStateMachine;

import java.util.Map;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: CustomWithStateMachine
 * @Package: com.caicai.designpattern.spring.status.extend
 * @Description:
 * @author: yujie.wan
 * @date: 2021/3/26 11:40
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@WithStateMachine
public class CustomWithStateMachine {

    @OnTransitionStart
    public void deliveryStart(Message<String> message) {
        String payload = message.getPayload();
        System.out.println("payload = " + payload);
    }

    @OnTransition
    public void deliveryStatusUpdate(Message<String> message) {
        String payload = message.getPayload();
        System.out.println("payload = " + payload);
    }
}
