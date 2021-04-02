package com.caicai.feign.alert;

import com.caicai.feign.alert.entity.AlertMessage;
import com.caicai.feign.alert.service.AlertService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: AlertServiceTest
 * @Package: com.caicai.feign.alert
 * @Description:
 * @author: yujie.wan
 * @date: 2021/4/1 11:03
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@SpringBootTest
public class AlertServiceTest {

    @Autowired
    private AlertService alertService;

    @Test
    public void test() throws JsonProcessingException {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            AlertMessage alertMessage = new AlertMessage();
            alertMessage.setAppName("deliveryservice");
            alertMessage.setThrowable(e);
            alertMessage.setTrackingNo("sdlkfjasldkfj");
            alertService.alert(alertMessage);

        }
    }
}
