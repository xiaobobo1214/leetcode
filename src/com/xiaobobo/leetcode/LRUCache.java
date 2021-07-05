/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname LRUCache
 * @Description TODO
 * @Date 2021/3/29 下午2:51
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class LRUCache {

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

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size = 0;
    private int capacity = 0;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        final DLinkedNode node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        // 如果key存在
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }
        // 如果key不存在
        // 创建一个新节点
        DLinkedNode newNode = new DLinkedNode(key, value);
        // 添加进hash表
        cache.put(key, newNode);
        // 移至链表头部
        addToHead(newNode);
        // 如果超出容量 删除最后一个节点
        if (++size > capacity) {
            // 移除连表最后一个节点
            DLinkedNode removeNode = removeTail();
            // 删除hash表
            cache.remove(removeNode.key);
            --size;
        }
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private DLinkedNode removeTail() {
        DLinkedNode removeNode = tail.prev;
        removeNode(removeNode);
        return removeNode;
    }

}