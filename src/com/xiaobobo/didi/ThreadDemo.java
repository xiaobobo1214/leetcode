/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.didi;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname DiDi
 * @Date 2021/6/26 下午2:14
 * @Author xiaobobo
 * @Created by wangbo16@baijia.com
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true);
        new Thread(()->{
            while (true){
                try {
                    lock.lock();
                    System.out.println("1");
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }


        }).start();
        new Thread(()->{
            while (true){
                try {
                    lock.lock();
                    System.out.println("2");
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }


        }).start();
    }


}
