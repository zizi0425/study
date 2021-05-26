package com.caicai.springboot.beanFactory.cycleRefence;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: C
 * @Package: com.caicai.springboot.beanFactory.cycleRefence
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/26 15:00
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class C {
    @Autowired
    private A a;
    @Autowired
    private B b;

}
