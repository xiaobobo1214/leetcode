/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.nio;

import lombok.SneakyThrows;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Classname BufferTest
 * @Description TODO
 * @Date 2020/11/3 5:14 下午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class BufferTest {
    public static void main(String[] args) {
        testMappedByteBuffer();
    }


    /**
     * MappedByteBuffer
     * 1、可以使文件直接在内存中（堆外内存）修改，操作系统不需要拷贝一次
     */
    @SneakyThrows
    public static void testMappedByteBuffer(){
        RandomAccessFile rw = new RandomAccessFile("/tmp/channelTest.txt", "rw");
        FileChannel channel = rw.getChannel();
        // 参数1：使用的是读写模式
        // 参数2：0代表可以直接修改的起始位置
        // 参数3：映射到内存的大小
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        map.put(0,(byte)'A');
        map.put(3,(byte)'B');
    }

    public static void testReadOnlyBuffer() {
        ByteBuffer bf = ByteBuffer.allocate(1024);
        for (int i = 0; i < 64; i++) {
            bf.put((byte)i);
        }

        //读取
        bf.flip();
        ByteBuffer readOnlyBuffer = bf.asReadOnlyBuffer();
        bf.put((byte)1);
        readOnlyBuffer.put((byte)1);        // java.nio.ReadOnlyBufferException
    }

    public static void testBufferPutAndGet() {
        ByteBuffer bf = ByteBuffer.allocate(1024);
        bf.putInt(1);
        bf.putLong(2);
        bf.putShort((short) 3);
        bf.flip();
        System.out.println(bf.getLong(2));       // 65536
    }
}
