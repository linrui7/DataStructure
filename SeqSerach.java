package com.github7.Search;
/*
   Author:linrui
   Date:2019/8/6
   Content:顺序查找，无论有序还是无序，都是一个一个对比，但是效率低
*/

public class SeqSerach {
    public static void main(String[] args) {

    }

    public static int serach1(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        //如果没找到，返回-1
        return -1;
    }

    public static int serach2(int[] arr, int key) {
        //边界使用一个哨兵，免去了每次都要越界的判断
        int index = arr.length - 1;
        if (key == arr[index]) {
            return index;
        }
        arr[index] = key;
        int i = 0;
        //遍历查找，一直找到index才相等的话。i=index+1，
        // 如果不是的话，那么在index之前就有相同的值
        while (arr[i] != key) {
            i++;
        }
        return i == index + 1 ? -1 : i - 1;
    }

}
