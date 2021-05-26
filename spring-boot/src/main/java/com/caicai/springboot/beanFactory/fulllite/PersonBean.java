package com.caicai.springboot.beanFactory.fulllite;

import com.caicai.springboot.beanFactory.entity.School;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: PersonBean
 * @Package: com.caicai.springboot.beanFactory.fulllite
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/25 18:18
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
public class PersonBean {

    @Bean
    public School school() {
        return new School();
    }

}
