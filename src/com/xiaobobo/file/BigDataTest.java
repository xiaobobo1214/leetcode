/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.file;

import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname BigDataTest
 * @Description TODO
 * @Date 2021/1/7 下午4:39
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class BigDataTest {

    public static void main(String[] args) {
        final long start = System.currentTimeMillis();
        testBigData();
        final long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
    }

    public static void testBigData() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dateStr = dateFormat.format(date);
        String filename = "/tmp/filetest/" + dateStr + ".txt";

        try {
            //testWriteFile(filename);
            testReadFile2(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testWriteFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }

        int row = 350000;
        long number = 2000000000000000L;
        List<String> lines = new ArrayList<>(row);
        for (int i = 0; i < row; i++) {
            lines.add(String.valueOf(number++));
        }
        IOUtils.writeLines(lines, null, new FileOutputStream(file));
    }

    public static List<Long> testReadFile1(String fileName) throws IOException {
        int partitionSize = 10000;
        final List<String> strings = FileUtils.readLines(new File(fileName));
        AtomicInteger i = new AtomicInteger();
        Lists.partition(strings, partitionSize).parallelStream().forEach(list -> {
            list.forEach(number -> {
                Long.valueOf(number);
            });
            System.out.println(i.getAndIncrement());
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return null;
    }
    public static List<Long> testReadFile2(String fileName) throws IOException {
        int maxSize = 8000;
        final LineIterator lineIterator = FileUtils.lineIterator(new File(fileName));
        List<Long> list = new ArrayList<>();
        while (lineIterator.hasNext()){
            list.add(Long.valueOf(lineIterator.nextLine()));
            if( list.size() == maxSize ){
                push(list);
                list = new ArrayList<>();
            }
        }
        return null;
    }
    private static int i = 0;
    private static void push(List<Long> list){
        System.out.println(i++);

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
