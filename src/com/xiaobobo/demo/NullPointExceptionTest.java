/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.demo;

/**
 * @Classname NullPointExceptionTest
 * @Description TODO
 * @Date 2020/8/26 8:32 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class NullPointExceptionTest {

    public static void main(String[] args) {
        test(null);
    }
    public static String test(Integer nullInteger){
        try {
            int a = nullInteger + 2;
            return "ok";
        }catch (Exception e){
            System.out.println("java.lang.NullPointerException");
            return null;
        }
    }

}
