package com.caicai.springboot.controller;

import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: TestController
 * @Package: com.caicai.springboot.controller
 * @Description:
 * @author: yujie.wan
 * @date: 2021/3/22 11:32
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@RestController
@AutoConfigureRestDocs
public class TestController {


    @GetMapping("/200")
    public ResponseEntity response200() {
        return ResponseEntity.status(HttpStatus.OK).body("success");
    }

    @GetMapping("/500")
    public ResponseEntity response500() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("这是一次失败的请求");
    }

    @GetMapping("/get")
    public ResponseEntity response(@RequestParam Map<String, String> param) {
        if (param.containsKey("success")) {
            return ResponseEntity.status(HttpStatus.OK).body("success");
        }
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("这是一次失败的请求");
    }





}
