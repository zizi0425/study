package com.caicai.designpattern.spring.status.extend;

import com.caicai.designpattern.spring.status.enums.States;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: StateMachineBuilder
 * @Package: com.caicai.designpattern.spring.status.extend
 * @Description:
 * @author: yujie.wan
 * @date: 2021/3/26 11:47
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
public class CustomStateMachineBuilder {

    public StateMachine<String, String> buildMachine() throws Exception {
        StateMachineBuilder.Builder<String, String> builder = StateMachineBuilder.builder();
        builder.configureStates()
                .withStates()
                .initial(States.S1.name())
                .states(new HashSet<>(Arrays.asList(States.SI.name(), States.S2.name())));
        return builder.build();
    }
}
