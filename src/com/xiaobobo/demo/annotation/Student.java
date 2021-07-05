/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.demo.annotation;

public class Student {

    @AnnotationDemo(name = "xiaobobo", age = 3, score = {1, 2, 3})
    public int test() {
        return 1;
    }

}
