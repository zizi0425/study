package com.caicai.feign;

import com.caicai.feign.client.HttpStatusTestFeign;
import com.caicai.feign.client.UserFeign;
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
        ResponseEntity responseEntity = statusTestFeign.response200();
        System.out.println("responseEntity = " + responseEntity);
        Response entity = statusTestFeign.response500_01();
        System.out.println("entity.getBody() = " + entity.body());
        System.out.println("entity.getStatusCode() = " + entity.status());
    }

}
