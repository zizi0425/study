package com.caicai.designpattern.jdk.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: Observer
 * @Package: com.caicai.designpattern.jdk
 * @Description:
 * @author: yujie.wan
 * @date: 2021/2/4 13:59
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class Mom implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("o = " + o);
        System.out.println("arg = " + arg);
    }
}
