package com.caicai.springboot.core.springbean;

import com.caicai.springboot.entity.wapper.Car;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: BeanUtilsTest
 * @Package: com.caicai.springboot.core.springbean
 * @Description:
 * @author: yujie.wan
 * @date: 2021/1/28 14:07
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class BeanUtilsTest {

    @Test
    public void describe() {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car();
        car.setDriver(null);
        car.setName("333");
        car.setWheels(null);
        Map<String, String> stringObjectMap = objectMapper.convertValue(car, new TypeReference<Map<String, String>>() {

        });
        stringObjectMap.forEach((k, v) -> System.out.println("k = " + k + ",v = " + v));
        System.out.println("JSONObject.toJSONString(stringObjectMap) = " + JSONObject.toJSONString(stringObjectMap));

    }

}
