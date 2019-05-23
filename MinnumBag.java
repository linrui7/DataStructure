package com.github7;
/*
   Author:linrui
   Date:2019/5/23
   Content:
            小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。
         可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。

   思路：
       要想袋数尽量少，也就是8个每袋的越多越好。
       如果n为奇数，则不存在。输出-1；
       当n<6时，不能购买，输出-1；
      当n>6时：
          如果n可以被8整除（n%8==0），则袋数为n/8；
         如果n除8余下一个偶数，余数+8/6就是需要6的袋数
        余数只可能是2和4   所以余数2+8+8 4+8肯定可以被6整除
        minbag-1+2 或者 minbag-2+3
*/

import java.util.Scanner;

public class MinnumBag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(bag(n));
        }
    }

    public static int bag(int n) {
        int minbag = 0;
        //小于6个时无法购买
        //奇数个也无法凑成6或者8个一袋
        if (n % 2 != 0||n<6) {
            return -1;
        }
        //如果刚好能用8个的装满
        if (n % 8 == 0) {
            return minbag = n / 8;
        } else {
            //除以8之后剩余的
            minbag = n / 8;
            if (n % 8 / 6 == 0) {
                return minbag-1+2;
            } else {
                return minbag-2+3;
            }
        }
    }
}
