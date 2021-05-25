package com.caicai.jdkdemo.concurrent.entity;

import java.util.LinkedList;
import java.util.Queue;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: TaskQueue
 * @Package: com.caicai.jdkdemo.concurrent.entity
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/24 17:13
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class SynchronizedTaskQueue {

    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String taskName) {
        queue.add(taskName);
        //notify只唤醒一个线程; 如果代码逻辑步骤; 用notify会导致只唤醒了一次还没有成功执行;其他线程可能就不会执行了
//        this.notify();
        this.notifyAll();
    }

    public synchronized String getTask() throws InterruptedException {
        //用if的话;调用wait后释放锁; notify后直接执行remove可能会有NoSuchElementException的异常;
        //用while则还需要再判断一次queue的长度
        while (queue.isEmpty()) {
            //wait会释放锁
            this.wait();
        }
        return queue.remove();
    }

}
