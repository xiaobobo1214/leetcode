/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.sort;

import com.xiaobobo.sort.impl.QuickSort;

import java.util.Arrays;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2020/12/12 2:22 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {7,5,2,9,0,1,3,4,8,6};
        //Sort sort = new BubbleSort();
        //Sort sort = new SelectionSort();
        //Sort sort = new InsertSort();
        //Sort sort = new ShellSort();
        //Sort sort = new MergeSort();
        Sort sort = new QuickSort();
        //ort sort = new HeapSort();
        Arrays.stream(sort.sort(nums)).forEach(e->{
            System.out.print(e + " ");
        });
    }
}
