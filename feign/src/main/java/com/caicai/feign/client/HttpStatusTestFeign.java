package com.caicai.feign.client;

import feign.Response;
import feign.codec.Decoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: HttpStatusTestFeign
 * @Package: com.caicai.feign.client
 * @Description:
 * @author: yujie.wan
 * @date: 2021/3/22 11:40
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@FeignClient(name = "localhost",url = "localhost:10000")
public interface HttpStatusTestFeign {

    @GetMapping("/200")
    ResponseEntity response200();


    @GetMapping("/500")
    ResponseEntity response500();

    @GetMapping("/500")
    Response response500_01();



}

