package com.caicai.designpattern.jdk.observer;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: Main
 * @Package: com.caicai.designpattern.jdk
 * @Description:
 * @author: yujie.wan
 * @date: 2021/2/4 14:22
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class Main {

    public static void main(String[] args) {
        Mom mom = new Mom();
        ElderBaby elderBaby = new ElderBaby();
        elderBaby.addObserver(mom);
        elderBaby.sleep();
    }
}
