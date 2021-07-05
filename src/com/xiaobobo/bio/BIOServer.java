/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.bio;


import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Classname BIOServer
 * @Description TODO
 * @Date 2020/10/29 9:28 上午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class BIOServer {
    public static void main(String[] args) throws Exception {
        // 1、创建一个线程池
        // 2、当有客户端连接就创建一个线程池与之通信

        //ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            final Socket socket = serverSocket.accept();
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        handle(socket);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
            new Thread(()->{
                try {
                    handle(socket);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void handle(Socket socket) throws Exception {
        InputStream in = socket.getInputStream();
        byte[] bytes = new byte[1024];
        while (true) {
            int read = in.read(bytes);
            if (read != -1) {
                System.out.println(new String(bytes, 0, read));
            } else {
                break;
            }
        }

    }
}
