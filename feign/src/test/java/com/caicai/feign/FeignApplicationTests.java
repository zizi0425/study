package com.caicai.feign;

import com.caicai.feign.client.HttpStatusTestFeign;
import com.caicai.feign.client.HttpStatusTestFeign2;
import com.caicai.feign.client.HttpStatusTestFeign3;
import com.caicai.feign.client.UserFeign;
import com.caicai.feign.entity.DemoResponse;
import com.caicai.feign.entity.PassportResponse;
import com.caicai.feign.entity.UserResponse;
import feign.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class FeignApplicationTests {

    @Autowired
    UserFeign userFeign;

    @Autowired
    HttpStatusTestFeign statusTestFeign;

    @Autowired
    HttpStatusTestFeign2 httpStatusTestFeign2;

    @Autowired
    HttpStatusTestFeign3 httpStatusTestFeign3;

    @Test
    void userTest() {
        PassportResponse<UserResponse> passportResponse = userFeign.getUserByUserCode("S112659886", true);
        System.out.println("passportResponse = " + passportResponse);
    }

    @Test
    void httpStatusFeignTest() {
        ResponseEntity responseEntity = statusTestFeign.response200();
        System.out.println("responseEntity = " + responseEntity);
        ResponseEntity responseEntity1 = statusTestFeign.response500();
        System.out.println("responseEntity1 = " + responseEntity1);
    }

    @Test
    void httpStatusFeignTest2() {
        ResponseEntity responseEntity = httpStatusTestFeign2.response200();
        System.out.println("responseEntity = " + responseEntity);
    }
    @Test
    void httpStatusFeignTest3() {
        DemoResponse<String> responseEntity = httpStatusTestFeign3.response500();
        System.out.println("responseEntity = " + responseEntity);
    }

}
