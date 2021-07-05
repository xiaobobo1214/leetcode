/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.nio;

import lombok.SneakyThrows;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Classname NIOServer
 * @Description TODO
 * @Date 2020/11/4 9:32 上午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class NIOServer {

    public static void main(String[] args) {
        startServer();
    }

    @SneakyThrows
    public static void startServer() {
        // 创建一个ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 创建一个Selector
        Selector selector = Selector.open();

        // 绑定一个端口8888，在服务器端监听
        serverSocketChannel.socket().bind(new InetSocketAddress(8888));

        // 设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        // 把ServerSocketChannel注册到selector ， 关心的事件为 OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 循环等待客户端连接
        while (true) {
            // 没有事件发生
            if (selector.select(1000) == 0) {
                System.out.println("server waiting one second , no connection...");
                continue;
            }
            // 有事件发生 、 获取到相关的selectionKey集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()){
                SelectionKey key = keyIterator.next();
                // 根据key对应的通道发生的事件做相应处理
                if (key.isAcceptable()) {
                    // 发生的事件为OP_ACCEPT
                    // 因为已经有连接事件发生、所以accept()不会阻塞
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    // 将当前的SocketChannel注册到selector、关注事件为READ、同时给socketChannel关联一个buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }else if(key.isReadable()){
                    // 通过key反向获取到对应的Channel
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    // 获取到该channel关联的buffer
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    socketChannel.read(buffer);
                    System.out.println(new String(buffer.array()));
                }
                keyIterator.remove();
            }
        }

    }

}
