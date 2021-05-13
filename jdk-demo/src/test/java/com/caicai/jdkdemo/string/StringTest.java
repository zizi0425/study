package com.caicai.jdkdemo.string;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;
import sun.util.locale.StringTokenIterator;

import java.util.Arrays;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: StringTest
 * @Package: com.caicai.jdkdemo.string
 * @Description:
 * @author: yujie.wan
 * @date: 2021/1/13 13:42
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class StringTest {


    static ObjectMapper objectMapper;
    static {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void StringFormatTest() {
        String format = String.format("format: %s , %d ,%s", "123", 345, Lists.newArrayList("33","434"));
        System.out.println("format = " + format);
    }

    @Test
    public void NullTest() {
        System.out.println("new Date(1610706359999l) = " + new Date(1610706359999l));
        System.out.println("new Date(1610705099999) = " + new Date(1610705099999L));
    }

    @Test
    public void NullJsonTest() throws JsonProcessingException {
        String json = null;
        String s = objectMapper.writeValueAsString(json);
        System.out.println("StringUtils.hasLength(s) = " + StringUtils.hasLength(s));
        System.out.println("s = " + s);
    }


    @Test
    public void StringTest() {
        String url = "abc123def";
        boolean b = needIntergration(url);
        System.out.println("b = " + b);
        System.out.println("url = " + url);

    }


    @Test
    public void StringTokenIterator() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 60000; i++) {
            sb.append(i+"aaa").append(",");
        }
        String str = sb.toString();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",", false);
        while (stringTokenizer.hasMoreElements()) {
            System.out.println("stringTokenizer.nextElement() = " + stringTokenizer.nextElement());
        }

        String[] split = str.split(",");
        Arrays.asList(split).forEach(System.out::println);

    }


    public static boolean needIntergration(String url) {
        System.out.println("url = " + url);
        url = url.replaceFirst("abc", "123");
        System.out.println("url = " + url);
        return false;
    }


























}
