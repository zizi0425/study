package com.caicai.designpattern.jdk.listener;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: ElectricRiceCookerListener
 * @Package: com.caicai.designpattern.jdk.listener
 * @Description:
 * @author: yujie.wan
 * @date: 2021/2/7 10:15
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class ElectricRiceCookerListener implements KitchenListener {

    @Override
    public void execute(State state) {
        if (State.START == state) {
            System.out.println("电饭锅开始做饭: 打开电源");
        }
        if (State.END == state) {
            System.out.println("电饭锅开始做饭: 关闭电源");
        }
    }
}
