package com.caicai.springboot.beanFactory.fulllite;

import com.caicai.springboot.beanFactory.entity.Person;
import com.caicai.springboot.beanFactory.entity.School;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.UUID;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: PersonConfig
 * @Package: com.caicai.springboot.beanFactory.fulllite
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/25 18:04
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
//@Configuration(proxyBeanMethods = false)
public class PersonConfig {

    volatile Integer index = 1;
    @Bean
    Person person() {
        Person person = new Person();
        person.setName(UUID.randomUUID().toString());
        person.setAge(12);
        person.setSchool(school());
        return person;
    }

    @Bean
    public School school() {
        School school = new School();
        school.setName(UUID.randomUUID().toString());
        return school;
    }


}
