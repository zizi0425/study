package com.caicai.feign.alert.client;

import com.caicai.feign.alert.entity.WeChatWorkResponse;
import com.caicai.feign.alert.entity.WechatWorkAlertMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: WechatAlertClient
 * @Package: com.caicai.feign.alert.client
 * @Description:
 * @author: yujie.wan
 * @date: 2021/4/1 10:38
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@FeignClient(name = "wechatalert",url = "${wechat.work.alert.url:https://qyapi.weixin.qq.com}")
public interface WechatAlertClient {

    @PostMapping("cgi-bin/webhook/send")
    WeChatWorkResponse alert(@RequestParam("key") String key, @RequestBody WechatWorkAlertMessage alertMessage);
}
