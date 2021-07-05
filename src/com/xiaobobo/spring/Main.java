/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.spring;

import com.xiaobobo.spring.bean.A;
import com.xiaobobo.spring.bean.AppContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Classname Main
 * @Date 2021/5/7 下午4:19
 * @Author xiaobobo
 * @Created by wangbo16@baijia.com
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext app
                = new AnnotationConfigApplicationContext(AppContext.class);
        A a = app.getBean("a", A.class);
        System.out.println(a);
    }
}
