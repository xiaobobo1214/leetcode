/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

/**
 * @Classname S860
 * @Description TODO
 * @Date 2020/12/10 10:26 上午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class S860 {

    public boolean lemonadeChange(int[] bills) {
        int money5 = 0;
        int money10 = 0;
        for(int i = 0;i<bills.length;i++){
            if(bills[i]==5){
                money5++;
            }else if(bills[i]==10){
                if(money5<1){
                    return false;
                }else{
                    money10++;
                    money5--;
                }
            }else if(bills[i]==20){
                if(money10>0){
                    if(money5<1){
                        return false;
                    }
                    money10--;
                    money5--;

                }else {
                    if(money5<3){
                        return false;
                    }
                    money5 -= 3;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] bills = {5,5,5,5,20,20,5,5,20,5};
//        new S860().lemonadeChange(bills);

        System.out.println(int2Char(49));
    }
    public static int char2Int(char c){
        return (int)c - 48;
    }

    public static char int2Char(int i){
        return (char)i;
    }
}
