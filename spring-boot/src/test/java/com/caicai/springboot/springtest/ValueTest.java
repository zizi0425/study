package com.caicai.springboot.springtest;

import com.caicai.springboot.ApplicationTests;
import com.caicai.springboot.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Set;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: ValueTest
 * @Package: com.caicai.springboot.springtest
 * @Description:
 * @author: yujie.wan
 * @date: 2021/2/1 10:13
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class ValueTest extends ApplicationTests {
//    @Autowired
    TestConfig testConfig;

    @Value("${test.partnerIds:1563,4564,8569}")
    private Set<String> testPartnerIds;

    @Test
    public void valueTest1() {
        testConfig.getPartnerIds().stream().forEach(System.out::println);
    }

    @Test
    public void valueTest2() {
        testPartnerIds.stream().forEach(System.out::println);
    }
}
