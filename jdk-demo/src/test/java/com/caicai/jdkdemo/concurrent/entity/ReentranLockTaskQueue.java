package com.caicai.jdkdemo.concurrent.entity;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * All rights Reserved, Designed By www.freemud.cn
 *
 * @version V1.0
 * @Title: ReentranLockTaskQueue
 * @Package: com.caicai.jdkdemo.concurrent.entity
 * @Description:
 * @author: yujie.wan
 * @date: 2021/5/24 17:58
 * @Copyright: 2021 www.freemud.cn Inc. All rights reserved.
 * 注意：本内容仅限于上海非码科技内部传阅，禁止外泄以及用于其他的商业目
 */
public class ReentranLockTaskQueue {

    final ReentrantLock lock = new ReentrantLock();

    /**
     * Condition必须从Lock示例中获取这样才能绑定一个Lock实例的Condition实例
     * Condition 和 synchronized的同义方法
     * await()  -> wait()
     * signal() -> notify()
     * signalAll() -> notifyAll()
     * 不过Condition可以通过await的重载方法来设置等待时间
     */
    final Condition condition = lock.newCondition();

    private Queue<String> queue = new LinkedList<>();

    public void addTask(String task) {
        lock.lock();
        try{
            queue.add(task);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public String getTask() {
        lock.lock();
        try{
            while (queue.isEmpty()) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                }
            }
            return queue.remove();
        }finally {
            lock.unlock();
        }
    }
}
