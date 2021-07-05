package com.xiaobobo.demo.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface AnnotationDemo {

    String name();

    int age() default 18;

    int[] score();
}

class Main{

    public static void main(String[] args) throws Exception {
        Class student = Class.forName("com.xiaobobo.demo.annotation.Student");
        Method method = student.getMethod("test");
        AnnotationDemo annotation = method.getAnnotation(AnnotationDemo.class);
        System.out.println("name:"+ annotation.name());
        System.out.println("age:"+ annotation.age());
        System.out.println("score:"+ annotation.score()[0]);
    }
}
