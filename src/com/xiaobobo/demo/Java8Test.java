/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.RandomUtils;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @Classname Java8Test
 * @Description java8新特性
 * @Date 2020/8/10 3:28 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class Java8Test {
    public static void main(String[] args) {
        test16();
    }


    public static void test16() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(2);
        list.add(4);
        list.add(6);
        Comparator keyComparator = Comparator.reverseOrder();
        // Comparator keyComparator = Comparator.naturalOrder();
        Comparator comparator = Comparator.comparing(Integer::intValue, keyComparator);
        System.out.println(list.stream().sorted(comparator).collect(Collectors.toList()));
    }


    public static void test15() {
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomUtils.nextInt(1, 4));
        }
    }


    @Data
    @AllArgsConstructor
    static class Student {
        private int id;
        private String name;
        private int age;
    }

    public static void test14() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        test14WithParam(list);
        System.out.println(list.size());
    }

    private static void test14WithParam(List<Integer> list) {
        list.stream().filter(integer -> integer != 0);
    }

    public static void test13() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add(i);
            list2.add(i);
            list3.add(i);
        }
        new Thread(() -> {
            final long start = System.currentTimeMillis();
            list1.forEach(e -> {
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                e++;
            });
            final long end = System.currentTimeMillis();
            System.out.println("forEach:" + (end - start) + "s");
        }).start();
        new Thread(() -> {
            final long start = System.currentTimeMillis();
            list2.stream().forEach(e -> {
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                e++;
            });
            final long end = System.currentTimeMillis();
            System.out.println("stream.forEach:" + (end - start) + "s");
        }).start();
        new Thread(() -> {
            final long start = System.currentTimeMillis();
            list3.parallelStream().forEach(e -> {
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                e++;
            });
            final long end = System.currentTimeMillis();
            System.out.println("parallelStream.forEach:" + (end - start) + "s");
        });
    }

    public static Long test12() {
        Long a = 10L;
        Long b = 1L;
        return Optional.ofNullable(a).get() - Optional.ofNullable(b).get();
    }

    public static void test11() throws Exception {
        CompletableFuture<Integer> res = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("innerThread");
            return 123;
        });
        System.out.println("outThread");
        System.out.println(res.get() + 321);
    }

    public static void test10() {
        List<Integer> numbers = Arrays.asList(5, 2, 3, 4, 1, 6);
        System.out.println(numbers.parallelStream().findAny().get());
    }

    public static void test09() {
        String val = "null1";
        Optional<String> optional = Optional.ofNullable(val);
        String optionalVal = optional.orElseThrow(() -> new RuntimeException("val is null"));
        System.out.println(optionalVal);

    }

    public void test08() {
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";
        String key5 = "key5";

        String value1 = "value1";
        String value2 = "value2";
        String value3 = "value3";
        String value4 = "value4";
        String value5 = "value5";

        TestStreamGroup test1 = new TestStreamGroup(key1, value1);
        TestStreamGroup test2 = new TestStreamGroup(key2, value2);
        TestStreamGroup test3 = new TestStreamGroup(key3, value3);
        TestStreamGroup test4 = new TestStreamGroup(key4, value4);
        TestStreamGroup test5 = new TestStreamGroup(key5, value5);

        ArrayList<TestStreamGroup> list = new ArrayList<>();
        list.add(test1);
        list.add(test2);
        list.add(test3);
        list.add(test4);
        list.add(test5);
        list.add(test5);
        Map<String, List<TestStreamGroup>> map = list.stream().collect(Collectors.groupingBy((TestStreamGroup::getKey)));
        for (Map.Entry<String, List<TestStreamGroup>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }

    @Data
    @AllArgsConstructor
    class TestStreamGroup {
        String key;
        String value;
    }

    /**
     * reduce()
     * 聚合操作，根据一定的规则将Stream中的元素进行计算后返回一个唯一值
     */
    public static void test07() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        Optional<List<Integer>> lists = Optional.of(list);
        //求和
        Integer sum = lists.get().stream().reduce((item1, item2) -> item1 + item2).get();
        System.out.println(sum);
        //求最大值
        //Integer maxValue = Stream.of(5, 6, 7, 8, 3, 1, 5, 6, 8, 9, 0, 6, 5, 4, 3, 2, 2, 32, 5, 6, 23, 324, 1, 3, 1).reduce((max, now) -> max < now ? now : max).get();
        //System.out.println(maxValue);
    }

    /**
     * parallelStream并行流
     * java8中，parallelStream用fork/join框架提供了并发执行的能力
     * 多数情况下并行比串行快，当数据量较小时，可能串行更快，ForkJoin会耗性能、
     * 部分情况会有线程安全问题，
     * parallelStream里面使用的外部变量，比如集合一定要用线程安全的集合，不然会引发多线程安全的问题
     */
    public static void test06() {
        long start = System.currentTimeMillis();
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        //list.stream().forEach(System.out::print);
        list.parallelStream().forEach(System.out::print);
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start) + " ms");
    }

    /**
     * max min 获取集合中元素的最大值和最小值
     */
    public static void test05() {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer max = list.stream().max(Comparator.comparingInt(Integer::valueOf)).get();
        System.out.println(max);
        Integer min = list.stream().min(Comparator.comparingInt(Integer::valueOf)).get();
        System.out.println(min);
    }

    /**
     * stream.anyMatch()  集合中只要有一个元素相匹配就返回true
     * stream.allMatch()  集合中所有元素都匹配才返回true
     */
    public static void test04() {
        List<String> list = Arrays.asList("A", "B", "C", "D", "E", "F", "G");
        boolean allMatch = list.stream().allMatch(str -> str.length() == 1);
        System.out.println(allMatch);
        boolean anyMatch = list.stream().anyMatch(str -> "F".equals(str));
        System.out.println(anyMatch);
    }

    /**
     * stream limit操作 用于返回集合中指定数量的元素
     */
    public static void test03() {
        List<String> list = Arrays.asList("A", "B", "C", "D", "E", "F", "G");
        List<String> resultList = list.stream().limit(4).collect(Collectors.toList());
        System.out.println(resultList);
    }

    /**
     * stream sorted操作
     */
    public static void test02() {
        List<String> list = Arrays.asList("E", "C", "F", "A", "D", "G", "B");
        //默认排序
        List<String> sortedList1 = list.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList1);
        //默认排序的倒序
        List<String> sortedList2 = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedList2);
        //根据字符串的length进行排序
        List<String> resultList3 = list.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        System.out.println(resultList3);
    }


    /**
     * stream map操作
     */
    public static void test01() {
        List<String> list = Arrays.asList("A", "B", "C", "D", "E", "F", "G");
        //遍历集合 对集合中的每一个对象做处理
        List<String> resultList1 = list.stream().map(str -> str.toLowerCase()).collect(Collectors.toList());
        System.out.println(resultList1);

        List<String> resultList2 = list.stream().map(str -> {
            String res = str + str.toLowerCase();
            return res;
        }).collect(Collectors.toList());
        System.out.println(resultList2);
    }


}