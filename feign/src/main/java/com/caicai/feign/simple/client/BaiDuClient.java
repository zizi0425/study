package com.caicai.feign.simple.client;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: BaiDuClient
 * @Package: com.caicai.feign.simple.client
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/21 14:32
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@FeignClient(contextId = "baidu", name = "baidu", url = "www.baidu.com")
public interface BaiDuClient {

    @GetMapping
    default Response get() {
        throw new RuntimeException("暂不支持");
    }
}
