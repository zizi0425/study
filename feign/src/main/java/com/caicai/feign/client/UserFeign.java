package com.caicai.feign.client;

import com.caicai.feign.config.BaseFeignConfig;
import com.caicai.feign.entity.PassportResponse;
import com.caicai.feign.entity.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "PASSPORT",
        url = "http://passport-base-koderover-dev-open-store.api-ingress.sandload.cn",
        configuration = {BaseFeignConfig.class}
)
public interface UserFeign {

    @GetMapping({"/api/v1/user/getUserByUserCode"})
    PassportResponse<UserResponse> getUserByUserCode(@RequestParam("userCode") String var1, @RequestParam("needRole") Boolean var2);

}
