///*
// * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
// */
//package com.xiaobobo.net;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.net.URLConnection;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//import java.util.Map;
//
///**
// * @Classname Demo
// * @Date 2021/6/30 下午3:32
// * @Author xiaobobo
// * @Created by wangbo16@baijia.com
// */
//public class Demo {
//
//    public static void main(String[] args) {
//        String template = "https://api.gaotu100.com/mall/coin-mall/sign/signCount?date=%date&day=%day";
//        LocalDate date = LocalDate.of(2021, 6, 16);
//        do {
//            String dateStr = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//            String url = new StringBuilder(template).toString().replace("%date", dateStr).replace("%day", "0");
//            String url3 = new StringBuilder(template).toString().replace("%date", dateStr).replace("%day", "3");
//            String url5 = new StringBuilder(template).toString().replace("%date", dateStr).replace("%day", "5");
//            String url7 = new StringBuilder(template).toString().replace("%date", dateStr).replace("%day", "7");
//
//            String body = sendGet(url);
//            String body3 = sendGet(url3);
//            String body5 = sendGet(url5);
//            String body7 = sendGet(url7);
//            RestResponseVO<Double> response = new Gson().fromJson(body, RestResponseVO.class);
//            RestResponseVO<Double> response3 = new Gson().fromJson(body3, RestResponseVO.class);
//            RestResponseVO<Double> response5 = new Gson().fromJson(body5, RestResponseVO.class);
//            RestResponseVO<Double> response7 = new Gson().fromJson(body7, RestResponseVO.class);
//
//            final Integer data = response.getData().intValue();
//            final Integer data3 = response3.getData().intValue();
//            final Integer data5 = response5.getData().intValue();
//            final Integer data7 = response7.getData().intValue();
//            //System.out.println(dateStr + "签到人数为：" + data + "，签到3天的人数为：" + data3 + "，签到5天的人数为：" + data5 + "签到7天的人数为：" + data7);
//            System.out.printf(data + "\t" + data3 + "\t" + data5 + "\t" + data7 + "\n");
//            date = date.plusDays(1);
//        } while (date.isBefore(LocalDate.now()));
//    }
//
//    public static String sendGet(String url) {
//        String result = "";
//        BufferedReader in = null;
//        try {
//            String urlNameString = url;
//            URL realUrl = new URL(urlNameString);
//            // 打开和URL之间的连接
//            URLConnection connection = realUrl.openConnection();
//            // 设置通用的请求属性
//            connection.setRequestProperty("accept", "*/*");
//            connection.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("user-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            // 建立实际的连接
//            connection.connect();
//            // 获取所有响应头字段
//            Map<String, List<String>> map = connection.getHeaderFields();
//            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
//            // 定义 BufferedReader输入流来读取URL的响应
//            in = new BufferedReader(new InputStreamReader(
//                    connection.getInputStream()));
//            String line;
//            while ((line = in.readLine()) != null) {
//                result += line;
//            }
//        } catch (Exception e) {
//            System.out.println("发送GET请求出现异常！" + e);
//            e.printStackTrace();
//        }
//        // 使用finally块来关闭输入流
//        finally {
//            try {
//                if (in != null) {
//                    in.close();
//                }
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        }
//        return result;
//    }
//}
