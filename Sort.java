package com.gitee7;
/*
    Name:  linrui
    Date: 2019/4/27
*/
/*
 * 1.插入排序       每次在无序的中，取一个，放到有序部分
 * 2.希尔排序       分组插排
 * 3.选择排序       走一趟，记录最小的数，放到最前面
 * 4.堆排序         理由二叉堆，选择最大的数
 * 5.冒泡排序       每次找最大的，然后放到最后面
 * 6.快速排序       基准值，小左大右
 * 7.归并排序       合并两个有序数组
 * */

public class Sort {


    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    //冒泡排序
    static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    //选择排序
    static void selectSort(int[] array) {
        int minIndex;
        for (int i = 0; i < array.length; i++) {
            minIndex = i;

            //在无序队列中找到最小值的下标为j
            int j;
            for (j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            //将无序队列中最小的放入到有序队列最后
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

    //堆排序
    static void heapSort(int[] array) {
        //首先创建一个大堆
        //找到第一个非叶子节点，进行调整
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            //从上往下，从左往右调整
            heapify(array, i, array.length);
        }
        for (int j = array.length - 1; j > 0; j--) {
            int tmp = array[0];
            array[0] = array[j];
            array[j] = tmp;
            heapify(array, 0, j);
        }
    }

    //调整堆
    static void heapify(int[] array, int i, int length) {
        //取出当前的非叶子节点
        int tmp = array[i];
        //进行调整，当前节点和子节点比较，谁大谁在上面
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //先比较两个子节点大小。大的向上走
            if (array[k] < array[k + 1] && k + 1 < length) {
                k++;
            }
            //如果父节点小于子节点。互换
            if (tmp < array[k]) {
                array[i] = array[k];
                i = k;
            } else {
                break;
            }
        }
        array[i] = tmp;
    }


    //归并排序
    //合并区间得到一个有序区间
    public static void mergeSort(int[] array) {
        int[] extra = new int[array.length];

    }
    static void mergeSortInner(int[] array, int low, int high, int[] extra) {
        // array[low, high)
        // [3, 4)
        if (low == high - 1) {
            return;
        }
        if (low >= high) {
            return;
        }
        // 1. 平均切分
        int mid = low + (high - low) / 2;
        // [low, mid) + [mid, high)
        // 2. 分治算法处理所有两个小区间
        mergeSortInner(array, low, mid, extra);
        mergeSortInner(array, mid, high, extra);

        // 左右两个小区间已经有序了
        merge(array, low, mid, high, extra);
    }
    static void merge(int[] array, int low, int mid, int high, int[] extra) {
        int i = low;    // 遍历 array [low, mid)
        int j = mid;    // 遍历 array [mid, high)
        int x = 0;      // 遍历 extra

        while (i < mid && j < high) {
            if (array[i] <= array[j]) {
                extra[x++] = array[i++];
            } else {
                extra[x++] = array[j++];
            }
        }

        while (i < mid) {
            extra[x++] = array[i++];
        }

        while (j < high) {
            extra[x++] = array[j++];
        }

        for (int k = low; k < high; k++) {
            array[k] = extra[k - low];
        }
    }

    //快速排序
    //1.将最后一个数作为基准值
    //2.所有数和基准值比较，小的放在左边，大的放右边
    //3.左右各找一个基准，然后再进行第二步。
    void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }
    int partition2(int[] array, int left, int right) {
        int d = left;
        int pivot = array[right];
        for (int i = left; i < right; i++) {
            if (array[i] < array[right]) {
                swap(array, d, right);
                d++;
            }
        }
        return d;
    }
    int partition1(int[] array, int left, int right) {
        int begin = left;
        int end = right;
        int pivot = array[right];
        while (begin < end) {

            if (begin < end && array[begin] > pivot) {
                array[end] = array[begin];
            }
            if (begin < end && array[end] < pivot) {
                array[begin] = array[end];
            }
            if (begin == end || begin < end) {
                break;
            }
            begin++;
            end--;
        }
        return begin;
    }

    //插入排序
    void insertSort1(int[] array) {
        //首先取出第一个元素，再取出第二个。如果比它大放在后面，如果比它小。放在前面
        for (int i = 0; i < array.length; i++) {
            int j;
            //当前数和有序队列比较，找到下标，使得当前下标的值之前比它都小
            for (j = i - 1; j >= 0 && array[i] < array[j]; j--) {
            }
            //找到下标之后，把下标之后的所有值都向后移动一个，把当前值插入进来
            //比它大的数都要移动
            int pos = j + 1;
            int key = array[i];
            for (int k = i; k > pos; k--) {
                array[k] = array[k - 1];
            }
            //移动完之后 中间空出来的就是当前值的位置
            array[pos] = key;
        }
    }

   static void insertSort2(int[] array) {
      // {1, 5, 8, 9, 7, 6, 8}
       //          j  i
        for(int i=0;i<array.length;i++){
            int key=array[i];
            int j=i-1;
            //定义前后下标，如果当前值比前面的小。则前面的向后移
            for(;j>=0&&key<array[j];j--){
                array[j+1]=array[j];
            }
            array[j+1]=key;
        }
    }

    //希尔排序
    static void insertSortGap(int []array,int gap){
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i - gap;
            for (; j >= 0 && key < array[j]; j = j - gap) {
                array[j + gap] = array[j];
            }
            array[j + gap] = key;
        }
    }
    static void shellSort(int []array){
        int gap=array.length;
        while(true){
            gap=(gap/3)+1;
            insertSortGap(array,gap);
            if(gap==1){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 7, 6, 8};

        shellSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
