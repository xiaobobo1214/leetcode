/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.thread;


import org.apache.commons.codec.digest.DigestUtils;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname ThreadTest
 * @Date 2021/2/26 下午5:52
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class ThreadTest {

//    public static void main(String[] args) throws Exception {
//
//        final ThreadTest test = new ThreadTest();
//
//        //test.test5();
//        final CallableTest c = new CallableTest();
//        System.out.println(c.call());
//        final FutureTask<String> stringFutureTask = new FutureTask<>(c);
//
//
//
//    }
    public static void main(String[] args) {
        String secretKey = "545a0ad20647432986392790d23cde39";
        final long time = System.currentTimeMillis();
        System.out.println(time);
        System.out.println(DigestUtils.md5Hex(time + secretKey));
    }

    static class CallableTest implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "hello world";
        }
    }


    /**
     * threadLocal
     */
    public void test5() throws Exception{
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        Thread t1 = new Thread(()->{
            threadLocal.set(1);
            threadLocal.set(3);
            threadLocal.set(5);
        }, "thread1");
        Thread t2 = new Thread(()->{
            threadLocal.set(2);
            threadLocal.set(4);
            threadLocal.set(6);

        }, "thread2");
        t1.start();
        t2.start();
        Thread.sleep(100);
        System.out.println(threadLocal);
    }

    /**
     * AtomicInteger
     */
    public void test4(){
        AtomicInteger ac = new AtomicInteger();
        System.out.println(ac.incrementAndGet());
        System.out.println(ac.get());
    }

    /**
     * 线程池
     */
    public void test3(){

        BlockingQueue queue = new ArrayBlockingQueue(2);
        final ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 100L, TimeUnit.SECONDS, queue, new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(3 * 60 * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * 两个线程输出奇偶
     */
    public static void test1() {
        Lock obj = new Lock();
        obj.flag = true;
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (obj) {
                    if (obj.flag) {
                        System.out.println(i);
                        obj.flag = !obj.flag;
                        obj.notify();
                    } else {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "偶数线程->").start();


        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                synchronized (obj) {
                    if (!obj.flag) {
                        System.out.println(i);
                        obj.flag = !obj.flag;
                        obj.notify();
                    } else {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "奇数线程->").start();
    }

    static class Lock {
        Boolean flag;
    }

    volatile int a = 0;

    public void test2() throws Exception {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a++;
                }
            }).start();
        }

        Thread.sleep(1 * 1000L);
        System.out.println(a);
    }

}


