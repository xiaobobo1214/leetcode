/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

/**
 * @Classname StringDemo
 * @Date 2021/5/9 下午2:24
 * @Author xiaobobo
 * @Created by wangbo16@baijia.com
 */
public class StringDemo {

    public String method(String str) {
        int maxLength = 0;
        String res = "-1";
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            // 数字，找第二个字母的位置j - i
            // 字母 找下一个字母的位置
            int j = i + 1;
            int temp = isNumeric(arr[i]) ? 2 : 1;
            for (; j < arr.length; j++) {
                if (!isNumeric(arr[j])) {
                    temp--;
                }
                if (temp == 0) {
                    break;
                }
            }
            if (isNumeric(arr[i]) ? (temp == 0 || (temp == 1 && j == arr.length)) && j - i > maxLength : (temp == 0 || j == arr.length) && j - i - 1 > maxLength) {
                maxLength = j - i;
                res = str.substring(i, j);
            }
        }
        return res;
    }



    private boolean isNumeric(char c) {
        return c <= '9' && c >= '0';
    }

    public int M(String str){
        int result = -1;
        String res = "";
        for (int i = 0; i < str.length(); i++){
            int flag = 0;
            int length = 0;
            for (int j = i; j < str.length(); j++){
                int ch = str.charAt(j);
                if (ch <= 'z' && ch >= 'A'){
                    flag++;
                } else {
                    length++;
                }
                if (flag == 2 && length>0){
                    result = Math.max(result, length+1);
                    res = str.substring(i , j);
                }
                if (j == str.length() - 1 && length>0 && flag > 0 && flag <= 2){
                    result = Math.max(result, length+1);
                    res = str.substring(i , j);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "11AA11";
        StringDemo demo = new StringDemo();
        String res = demo.method(str);
        System.out.println(str + " -> " + res);
    }
}
