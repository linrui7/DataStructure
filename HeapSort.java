package com.github7.Sort;
/*

   堆排序
    任意节点的值>=左右孩子的值   大堆
    任意节点的值<=左右孩子的值   小堆

   堆的基本应用：找最值
   操作：

       向下调整（除了要调整的位置之外，其他位置已经满足堆）
       1.找到最大的孩子
       2.比较最大孩子的值和根的值
       3.如果上一步交换，继续调整
       直到 1.要调整的位置已经是叶子 2.要调整的位置已经是堆

       建堆
       1.从最后一个非叶子节点（最后一个节点的双亲节点size-1）向下调整。



*/

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 3, 5, 7, 6, 9, 0};
        heapSort(arr);
    }

    //堆排序
    public static void heapSort(int[] arr) {
        //调整堆 从最后一个非叶子节点进行调整
        for (int index = arr.length / 2 - 1; index >= 0; index--) {
            adjust(arr, arr.length, index);
        }
        //调整完之后将最大值和最后一个换
        //继续调整剩下部分
        for (int i = 0; i < arr.length - 1; i++) {
            int tmp = arr[0];
            arr[0] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = tmp;
            adjust(arr, arr.length - i - 1, 0);
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //调整堆
    public static void adjust(int[] arr, int size, int index) {
        //比较非叶子节点的左右节点
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left >= size) {
            return;
        }
        int maxIndex;
        maxIndex = left;
        //如果没有右孩子或者右孩子的值小于左孩子 最大值就是左孩子
        if (right < size) {
            if (arr[right] > arr[left]) {
                maxIndex = right;
            }
        }
        if (arr[index] >= arr[maxIndex]) {
            return;
        }
        //如果父节点比子节点小 交换
        int tmp = arr[index];
        arr[index] = arr[maxIndex];
        arr[maxIndex] = tmp;
        
        adjust(arr, size, maxIndex);

    }
}
