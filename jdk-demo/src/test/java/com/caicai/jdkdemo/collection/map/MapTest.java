package com.caicai.jdkdemo.collection.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: MapTest
 * @Package: com.caicai.jdkdemo.collection.map
 * @Description: 先当容器放到collection中
 * @author: yujie.wan
 * @date: 2021/2/8 15:42
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class MapTest {


    @Test
    public void test() {
        Map<String, String> map = new HashMap<>();
        String s = map.get("234");
        s = "333";
        System.out.println("map.get(\"234\") = " + map.get("234"));

        map.put("123", null);
        String s1 = map.get("123");
        s1 = "32332";
        System.out.println("map.get(\"123\") = " + map.get("123"));
    }

}
