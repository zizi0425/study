package com.caicai.designpattern.jdk.listener;

import java.util.EventListener;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: Listerer
 * @Package: com.caicai.designpattern.jdk.listener
 * @Description:
 * @author: yujie.wan
 * @date: 2021/2/6 14:15
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public interface KitchenListener<T extends State> extends EventListener{

    void execute(T t);

}
