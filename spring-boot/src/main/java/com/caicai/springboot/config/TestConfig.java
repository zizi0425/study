package com.caicai.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: TestConfig
 * @Package: com.caicai.springboot.config
 * @Description:
 * @author: yujie.wan
 * @date: 2021/2/1 10:17
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
//@Configuration
public class TestConfig {

    @Value("${test.partnerIds:1563,4564,8569}")
    private Set<String> testPartnerIds;

    public Set<String> getPartnerIds() {
        return testPartnerIds;
    }
}
