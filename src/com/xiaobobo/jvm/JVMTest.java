/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname JVMTest
 * @Description TODO
 * @Date 2020/12/29 下午4:32
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class JVMTest {


    /**
     * -Xss  虚拟机栈的大小
     * 160k  1800
     * 默认大小 数据：10823
     * @param i
     */
    public static void stackTest(int i){
        System.out.println(i);
        stackTest(++i);
    }

    public static void heapTest(){
        int i = 0;
        for (;;) {
            Map map = new HashMap(1024);
            System.out.println(i++);
        }
    }


    public static void main(java.lang.String[] args) throws Exception{
        ClassLoader classLoader = Class.forName("com.xiaobobo.jvm.String").getClassLoader();
        System.out.println(classLoader);
        System.out.println(Runtime.getRuntime().totalMemory());
    }
}
class String{
    public void print(int i){
        System.out.println(i);
    }
}
