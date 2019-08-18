/*
   Author:linrui
   Date:2019/8/17
   Content:快排
    取出排序元素中的某一个值作为基准值，然后将排序数组分成两个部分，一部分小于基准值
    一部分大于基准值。然后左右子数组重复该排序过程。
*/

public class QuickSort {
    public void quickSort(int[] array, int low, int hight) {
        if (low > hight) {
            return;
        }
        //定义一个基准值
        int tmp = array[low];
        int i = low;
        int j = hight;
        int t;
        while (i < j) {
            //从后往前找到比基准值小的数
            while (tmp <= array[j] && i < j) {
                j--;
            }
            //从前完后找一个比基准值大的数
            while (tmp >= array[i] && i <j){
                i++;
            }
            //找到之后进行交换
            if (i < j) {
                t = array[j];
                array[j] = array[i];
                array[i] = t;
            }
        }
        //交换完毕
        array[low] = array[i];
        array[i] = tmp;
        //此时的tmp已经找到了自己的位置。一个数字已经排好序
        //递归调用左右无序数组
        quickSort(array, low, j - 1);
        quickSort(array, j + 1, hight);
    }
}
