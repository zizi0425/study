package com.caicai.designpattern.jdk.listener;

import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: Main
 * @Package: com.caicai.designpattern.jdk.listener
 * @Description:
 * @author: yujie.wan
 * @date: 2021/2/7 10:18
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class Main {

    private static List<KitchenListener> listeners = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("进入厨房");
        listeners.add(new ElectricRiceCookerListener());

        listeners.forEach(kitchenListener -> kitchenListener.execute(State.START));
        listeners.forEach(kitchenListener -> kitchenListener.execute(State.END));
    }
}
