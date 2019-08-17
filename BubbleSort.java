/*
   Author:linrui
   Date:2019/8/17
   Content:冒泡排序
   从第一个数开始，与后面的数比较选择一个最大的数。然后依次循环。寻找第二大的数。

*/

public class BubbleSort {
    public static<T extends Object> void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 1, 8, 10};
        bubbleSort(arr);

    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static <T extends Comparable<T>> void bubble(T[] arr) {
        boolean swap = false;
        for (int i = 0; i < arr.length - 1 && swap; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                //arr[j]>arr[j+1]大于1 说明成立
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swap = true;
                }
            }
        }
        for (T i : arr) {
            System.out.print(i + " ");
        }
    }
}
