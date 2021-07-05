/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.nio;

import lombok.SneakyThrows;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Classname NIOClient
 * @Description TODO
 * @Date 2020/11/5 9:31 上午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class NIOClient {
    public static void main(String[] args) {
        sendMessage();
    }

    @SneakyThrows
    public static void sendMessage() {
        // 得到一个网络通道
        SocketChannel socketChannel = SocketChannel.open();
        // 设置为非阻塞
        socketChannel.configureBlocking(false);
        // 提供服务端的ip和端口
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8888);
        // 如果没有连接到不回阻塞，可以做其他动作
        if (!socketChannel.connect(address)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("connecting server ...");
            }
        }
        //连接成功、发送数据
        String message = "hello world";
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
        socketChannel.write(buffer);
        System.in.read();
    }
}
