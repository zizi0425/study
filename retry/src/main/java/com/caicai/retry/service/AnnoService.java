package com.caicai.retry.service;

import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: Anno
 * @Package: com.caicai.retry.service
 * @Description:
 * @author: yujie.wan
 * @date: 2021/2/3 14:15
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Service
public class AnnoService {

    @Retryable(listeners = "retryListenerSupport",recover = "recover",label = "retryTest")
    public void retry() {
        throw new RuntimeException("333333");
    }

    @Recover
    public void recover(RuntimeException e) {
        System.out.println("异常了"+ e.getLocalizedMessage()) ;
    }
}
