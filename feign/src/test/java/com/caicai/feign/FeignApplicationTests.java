package com.caicai.feign;

import com.caicai.feign.client.UserFeign;
import com.caicai.feign.entity.PassportResponse;
import com.caicai.feign.entity.UserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FeignApplicationTests {

    @Autowired
    UserFeign userFeign;

    @Test
    void contextLoads() {
        PassportResponse<UserResponse> passportResponse = userFeign.getUserByUserCode("S112659886", true);
        System.out.println("passportResponse = " + passportResponse);
    }

}
