/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.mianshi;

/**
 * @Classname Synchronzied
 * @Description TODO
 * @Date 2020/12/25 上午10:39
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class Synchronized {

    public void syncBlock() {
        synchronized (this) {
            System.out.println("syncBlock");
        }
    }

    public synchronized void syncMethod() {
        System.out.println("syncMethod");
    }

}
