package com.caicai.springboot.beanFactory.entity;

import lombok.Data;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: Person
 * @Package: com.caicai.springboot.beanFactory.entity
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/25 18:05
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Data
public class Person {
    private String name;

    private Integer age;

    private School school;
}
