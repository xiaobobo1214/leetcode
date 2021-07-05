/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.nio;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Classname ChannelTest
 * @Description TODO
 * @Date 2020/11/3 4:20 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class ChannelTest {
    public static void main(String[] args) throws Exception {
        testCopyChannelToChannel();
    }

    @SneakyThrows
    public static void testCopyChannelToChannel() {
        FileInputStream source = new FileInputStream("/tmp/channelTest.txt");
        FileChannel sourceChannel = source.getChannel();
        FileOutputStream target = new FileOutputStream("/tmp/channelTest.txt.bak");
        FileChannel targetChannel = target.getChannel();

        targetChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
    }

    @SneakyThrows
    public static void testCopy() {
        FileInputStream source = new FileInputStream("/tmp/channelTest.txt");
        FileChannel sourceChannel = source.getChannel();
        FileOutputStream target = new FileOutputStream("/tmp/channelTest.txt.bak");
        FileChannel targetChannel = target.getChannel();

        ByteBuffer bf = ByteBuffer.allocate(10);

        while (true) {
            bf.clear();
            int read = sourceChannel.read(bf);
            if (read == -1) {
                break;
            }
        }
        System.out.println(new String(bf.array()));
        //bf.flip();
        targetChannel.write(bf);
    }

    @SneakyThrows
    public static void testRead() {
        File file = new File("/tmp/channelTest.txt");
        FileInputStream fis = new FileInputStream(file);
        FileChannel channel = fis.getChannel();
        ByteBuffer bf = ByteBuffer.allocate((int) file.length());
        channel.read(bf);
        System.out.println(new String(bf.array()));
    }

    @SneakyThrows
    public static void testWrite() {
        File file = new File("/tmp/channelTest.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ByteBuffer bf = ByteBuffer.allocate(1024);
        String content = "hello channel";
        bf.put(content.getBytes());

        bf.flip();

        FileChannel channel = fos.getChannel();
        channel.write(bf);
    }
}
