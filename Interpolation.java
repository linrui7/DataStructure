package com.github7.Search;
/*
   Author:linrui
   Date:2019/8/6
   Content:插值查找。
   对于表长较大，而关键字分布又比较均匀的查找表来说，插值查找算法的平均性能比折半查找要好得多 。
*/

public class Interpolation {
    public static int interpolation(int[] arr, int value) {
        int low = 0;
        int hight = arr.length;
        while (low <= hight) {
            //插值公式
            int middle = low + (hight - low) * (value - arr[low]) / (arr[hight] - arr[low]);
            if (middle == value) {
                return middle;
            }
            if (value > middle) {
                low = middle + 1;
            }
            if (value < middle) {
                hight = middle - 1;
            }
        }
        return -1;
    }
}
