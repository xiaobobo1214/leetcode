/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.thread;

import java.io.Serializable;

/**
 * @Classname PrintABC
 * @Date 2021/6/7 下午10:17
 * @Author xiaobobo
 * @Created by wangbo16@baijia.com
 */
public class PrintABC implements Serializable {

    private static final Object lock = new Object();

    public static void main1(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 26; i++) {
                    System.out.print((char) ('a' + i));
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 26; i++) {
                    System.out.print((char) ('A' + i));

                    lock.notifyAll();
                    try {
                        if (i != 25) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }

//    public static void main(String[] args) {
//        BigDecimal sum = BigDecimal.valueOf(0);
//        for (int i = 2; i < 100; i++) {
//            int temp = 0;
//            for (int j = 2; j < i; j++) {
//                if (i % j == 0) {
//                    temp = 1;
//                }
//            }
//            if (temp != 1) {
//                BigDecimal tempSum = BigDecimal.valueOf(1);
//                for (int j = 1; j <= i; j++) {
//                    tempSum = tempSum.multiply(BigDecimal.valueOf(j));
//                }
//                sum = sum.add(tempSum);
//            }
//        }
//        System.out.println(sum);
//    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,2,4,9};
        String s = new String("hello");
        test(s);
        System.out.println(s);
    }


    public static void test(String s){
        s = new String("word");
    }


    public int getRes(int[] nums){
        if(nums==null || nums.length == 0){
            return 0;
        }
        int maxProfit = 0;
        int minPirce = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]  < minPirce){
                minPirce = nums[i];
            }else if(nums[i] - minPirce > maxProfit){
                maxProfit = nums[i] - minPirce - 2;
            }
        }
        return maxProfit;
    }
}
