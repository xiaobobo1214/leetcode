/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.demo;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @Classname Test
 * @Description TODO
 * @Date 2020/7/16 8:03 下午
 * @Created by wangbo16@baijiahulian.com˙
 */
public class Test {

    public static void main(String[] args) {
        //func7();
        //isSubsequence("bb", "ahbgdc");
        //Integer.valueOf(123);


        StringBuffer sb = new StringBuffer("https://gsx1.cn/c7c4532_3");
        StringBuffer url = new StringBuffer("https://gsx16.cn");
        url.append(sb.substring(sb.lastIndexOf("/"), sb.length()));
        System.out.println(url);

    }

    public static boolean isSubsequence(String s, String t) {
        int sL = s.length();
        int tL = t.length();
        int index = 0;
        for (int i = 0; i < sL; i++) {
            char c = s.charAt(i);
            for (; index < tL; index++) {
                if (sL - i > tL - index) {
                    return false;
                }
                if (c == t.charAt(index)) {
                    if (i == sL - 1) {
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }

    public static int comp(int x, int y) {
        long a = 1, b = 1;
        for (int i = 1; i <= y; i++) {
            a *= (x + 1 - i);
            b *= i;
        }
        return (int) (a / b);
    }

    public static void func7() {
        methodA(methodB(methodC(0)));
    }

    public static int methodA(int i) {
        System.out.println("enter methodA...");
        return 0;
    }

    public static int methodB(int i) {
        System.out.println("enter methodB...");
        return 0;
    }

    public static int methodC(int i) {
        System.out.println("enter methodC...");
        return 0;
    }


    public static void func6() {
        List<String> list = Arrays.asList("A", "B", "C", "D", "E", "F", "G");
        //遍历集合 对集合中的每一个对象做处理
        List<String> resultList = list.stream().map(str -> str.toLowerCase()).collect(Collectors.toList());
        System.out.println(resultList);
    }

    public static void func5() {
        Integer a = null;
        System.out.println(a + 1);
    }

    public static void func4() {
        List<User> list = new ArrayList<>();
        User user = new User("name1");
        list.add(user);
        user.setName("name2");
        list.add(user);
        System.out.println(list);
    }

    public static void func3() {

        List<String> list = Arrays.asList("springboot", "springcloud", "redis", "git", "netty", "java", "html", "docker");
        // 根据⻓长度进⾏行行排序
        List<String> resultList = list.stream().sorted(Comparator.comparing(
                obj -> obj.length())).collect(Collectors.toList());
        // List<String> resultList = list.stream().sorted(Comparator.comparing(obj -> obj.length(),Comparator.reverseOrder())).collect(Collectors.toList() );
        // List<String> resultList = list.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
        System.out.println(resultList);
    }

    /**
     * Stream的map方法
     */
    public static void func2() {

        List<String> list = Arrays.asList("springboot教程", "微服务教程", "并发编 程", "压⼒力力测试", "架构课程");
        List<String> resultList = list.stream().map(obj -> "在⼩小滴课堂 学:" + obj).collect(Collectors.toList());
        System.out.println(resultList);
    }


    /**
     * optional类
     */
    public static void func1() {

        //Optional<String> beforeStrOptional = Optional.of("abc");
        Optional<String> beforeStrOptional = Optional.empty();
        Optional<String> afterStrOptional = beforeStrOptional.map(temp -> {

            temp += "defg";
            return temp.toUpperCase();

        });


        if (1 == 1) {
            getFuncOld();
        }

        System.out.println(afterStrOptional);
    }

    /**
     * 已经过时   新接口getANew()
     */
    @Deprecated
    public static void getFuncOld() {

    }


}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
