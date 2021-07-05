/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname LRU
 * @Date 2021/6/3 下午3:54
 * @Author xiaobobo
 * @Created by wangbo16@baijia.com
 */
public class LRU {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, DLinkedNode> cache = new HashMap<>();
    int size;
    int capacity;
    private DLinkedNode head = new DLinkedNode();
    private DLinkedNode tail = new DLinkedNode();

    public int[] LRU(int[][] operators, int k) {
        this.init(k);
        int count = (int) Arrays.asList(operators).stream().filter(arr -> arr[0] == 2).count();
        int[] res = new int[count];
        int resIndex = 0;
        for (int i = 0; i < operators.length; i++) {
            // set
            if (operators[i][0] == 1) {
                this.set(operators[i][1], operators[i][2]);
            }
            // get
            else if (operators[i][0] == 2) {
                res[resIndex++] = this.get(operators[i][1]);
            }
        }
        return res;
    }

    private void init(int capacity) {
        head.next = tail;
        tail.prev = head;
        size = 0;
        this.capacity = capacity;
    }


    public int get(Integer key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void moveToHead(DLinkedNode node) {
        DLinkedNode headNext = head.next;
        head.next = node;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = head;
        node.next = headNext;
    }

    public void set(Integer key, Integer value) {
        DLinkedNode node = new DLinkedNode(key, value);
        cache.put(key, node);
        if (capacity == size) {
            remove(tail.prev);
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            return;
        }
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        size++;
    }

    public void remove(DLinkedNode node) {
        cache.put(node.key, null);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    public static void main(String[] args) {
        int[][] operators = new int[][]{
                {1, 324690837, 72487934},
                {1, 723504364, 369145172},
                {2, 324690837},
                {1, 724101438, 30727452},
                {1, 366967562, 290286156},
                {2, 366967562},
                {1, 21417066, 450706222},
                {1, 484359960, 121414361}
        };
        int k = 3;
        int[] res = new LRU().LRU(operators, k);
        System.out.println(Arrays.asList(res));

    }

}
