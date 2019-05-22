package com.github7;
/*
   Author:linrui
   Date:2019/5/22
   Content:读入一个字符串，输出字符串str中连续最长的数字串

*/

import java.sql.SQLOutput;
import java.util.Scanner;

public class LongestNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            outNum(str);
        }
    }

    public static void outNum(String str) {

        int maxlength = 0;
        int counts=0;
        int end=0;
        for (int i = 0; i < str.length(); i++) {
            //寻找str中的数字,直到数字结束
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                //如果是数字。count+1
                counts++;
                //对比此时的长度有没有最大的长度长
                if(counts>maxlength){
                    maxlength=counts;
                    end=i;
                }
            }else{
                counts=0;
            }
        }
        //此时已经保存了最长数字的最后一个下标，以及它的长度，打印输出
        System.out.println(str.substring(end-maxlength+1,end+1));

    }
}
