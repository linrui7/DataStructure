package com.github7.Sort;
/*
   Author:linrui
   Date:2019/8/28
   Content:
   归并排序是将 左边区间排序，右边排序。直到区间已经有序，直到区间已经有序 size=1
   合并两个有序区间

   nlogn
*/

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 3, 5, 7, 6, 9, 0};
        mergeSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void mergeSort(int[] arr) {
        int[] extra = new int[arr.length];
        mergerSortInternal(arr, 0, arr.length, extra);
    }

    //分组
    private static void mergerSortInternal(int[] arr, int low, int high, int[] extra) {
        if (low == high - 1 || low == high) {
            return;
        }
        int mid = low + ((high - low) >> 1);
        mergerSortInternal(arr, 0, mid, extra);
        mergerSortInternal(arr, mid, high, extra);
        //分组完成进行合并
        merge(arr, low, mid, high, extra);

    }

    private static void merge(int[] arr, int low, int mid, int high, int[] extra) {
        //合并左右
        int i = low;
        int j = mid;
        int index = 0;
        while (i < mid && j < high) {
            if (arr[i] <= arr[j]) {
                extra[index++] = arr[i++];
            } else {
                extra[index++] = arr[j++];
            }
        }

        while (i < mid) {
            extra[index++] = arr[i++];
        }
        while (j < high) {
            extra[index++] = arr[j++];
        }
        //将这一段有序的还原到原来的数组
        for (int k = low; k < high; k++) {
            arr[k] = extra[k-low];
        }
    }

}
