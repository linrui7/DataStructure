package com.github7.Search;
/*
   Author:linrui
   Date:2019/8/6
   Content:二分查找。
   适用于大的数据，前提是有序的数组。
*/

public class BinarySearch {
    public static void main(String[] args) {

    }

    public static int BinarySerach1(int[] arr, int value) {
        int low = 0;
        int hight = arr.length - 1;
        while (low <= hight) {
            //找到中间部分
            int middle = (low + hight) / 2;
            if (value == arr[middle]) {
                return middle;
            }
            //对比中间，如果中间大于value 那么value在low-mid之间
            if (value > arr[middle]) {
                low = middle + 1;
            }
            //对比中间，如果中间小于value 那么value在mid-hight之间
            if (value < middle) {
                hight = middle - 1;
            }
        }
        //找不到
        return -1;
    }

    //在进行求中间部分值的时候，数值可能会溢出，所以我们采用另一种求中间值的公式。
    public static int BinarySerach2(int[] arr, int value) {
        int low = 0;
        int hight = arr.length - 1;
        while (low <= hight) {
            //找到中间部分,采用移位运算，增加效率
            int middle = low + ((hight - low) >> 2);
            if (value == arr[middle])
                return middle;
            if (value > arr[middle])
                low = middle + 1;
            if (value < middle)
                hight = middle - 1;
        }
        return -1;
    }

    //二分查找递归写法
    public static int BinarySerach3(int[] arr, int value) {
        int low = 0;
        int hight = arr.length - 1;
        return MyBinSer(arr, low, hight, value);
    }

    public static int MyBinSer(int arr[], int low, int hight, int value) {
        //没找到
        if (low > hight) {
            return -1;
        }
        int middle = low + ((hight - low) >> 2);
        if (value == arr[middle]) {
            return middle;
        }
        //low-mid区间
        if (value < arr[middle]) {
            return MyBinSer(arr, low, middle - 1, value);
        }
        //mid-hight区间
        else if (value > arr[middle]) {
            return MyBinSer(arr, middle + 1, hight, value);
        } else {
            return -1;
        }
    }
}
