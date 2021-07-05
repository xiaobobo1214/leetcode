/*
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package com.xiaobobo.leetcode;

/**
 * @Classname S649
 * @Description TODO
 * @Date 2020/12/11 10:57 上午
 * @Author xiaobobo
 * @Created by wangbo16@baijiahulian.com
 */
public class S649 {
    public String predictPartyVictory(String senate) {
        int r = 0, d = 0;
        char[] arr = senate.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 'R'){
                r++;
                boolean haveD = false;
                for(int j = i; j < arr.length; j++){
                    if(arr[j] == 'D'){
                        arr[j] = 'X';
                        haveD = true;
                        break;
                    }
                }

            }else if(arr[i] == 'D'){
                d++;
                boolean haveR = false;
                for(int j = i; j < arr.length; j++){
                    if(arr[j] == 'R'){
                        arr[j] = 'X';
                        haveR = true;
                        break;
                    }
                }

            }
        }

        return r > d ? "Radiant":"Dire";
    }

    public static void main(String[] args) {
        new S649().predictPartyVictory("DDDDRRDDDRDRDRRDDRDDDRDRRRRDRRRRRDRDDRDDRRDDRRRDDRRRDDDDRRRRRRRDDRRRDDRDDDRRRDRDDRDDDRRDRRDRRRDRDRDR");
    }
}
