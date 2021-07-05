/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.mianshi;

import lombok.AllArgsConstructor;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname Sougou
 * @Date 2021/6/22 下午3:47
 * @Author xiaobobo
 * @Created by wangbo16@baijia.com
 */
public class SouGou {

    public static AtomicInteger count = new AtomicInteger(3);

    public static void main(String[] args) {

        Object lock = new Object();
        new Thread(() -> {
            while (true) {
                if (count.get() == 0) {
                    lock.notifyAll();
                    break;
                }
            }
            System.out.println("有3人到终点了" + "count = " + count.get());
        }).start();

        for (int i = 0; i < 8; i++) {
            new Thread(new SportMan(lock, i)).start();
        }
    }


}

@AllArgsConstructor
class SportMan implements Runnable {

    private Object lock;
    private Integer speed;

    @Override
    public void run() {
        Long result = 0L;
        try {
            result = new Running(speed, System.currentTimeMillis()).call();
            lock.wait();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId() + "跑了：" + result + "m");
    }
}

@AllArgsConstructor
class Running implements Callable<Long> {

    private Integer speed;
    private Long startTimeMillis;

    @Override
    public Long call() throws Exception {
        if (SouGou.count.get() > 0) {
            SouGou.count.decrementAndGet();
            return 100L;
        }
        return speed * (System.currentTimeMillis() - startTimeMillis);
    }
}
