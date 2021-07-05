/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.jvm;

/**
 * @Classname JVMStackTest
 * @Date 2021/6/18 上午10:10
 * @Author xiaobobo
 * @Created by wangbo16@baijia.com
 */
public class JVMStackTest {
    private static int i = 0;

    public static void main(java.lang.String[] args) {
        try {
            a();
        } catch (Error e) {
            System.out.println("======" + i);
            System.out.println(e.getMessage());
        }
    }

    public static void a() {
        System.out.println(i++);
        a();
    }

}
