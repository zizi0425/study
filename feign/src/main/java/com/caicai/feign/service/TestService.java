package com.caicai.feign.service;

import com.caicai.feign.client.HttpStatusTestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: TestService
 * @Package: com.caicai.feign.service
 * @Description:
 * @author: yujie.wan
 * @date: 2021/3/29 14:03
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
public class TestService {

    @Autowired
    private HttpStatusTestFeign httpStatusTestFeign;

}
