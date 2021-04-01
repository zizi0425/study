package com.caicai.designpattern.spring.status;

import com.caicai.designpattern.spring.status.enums.Events;
import com.caicai.designpattern.spring.status.enums.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: CommandLineRunner
 * @Package: com.caicai.designpattern.spring.status
 * @Description:
 * @author: yujie.wan
 * @date: 2021/3/26 9:36
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
public class StateMachineRunner implements org.springframework.boot.CommandLineRunner {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @Override
    public void run(String... args) throws Exception {
        stateMachine.sendEvent(Events.E1);
        stateMachine.sendEvent(Events.E2);
        stateMachine.sendEvent(Events.E1);
    }
}
