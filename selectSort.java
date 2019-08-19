/*
   Author:linrui
   Date:2019/8/19
   Content:
*/

public class selectSort {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, -1, 22};
        selectSort(arr);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.println(i);
        }
    }

    //选择排序，选最小的和第i个数交换
    public static void selectSort(int[] array) {
       for(int i=0;i<array.length;i++){
           int minIndex=i;
           for(int j=i+1;j<array.length;j++){
               if(array[j]<array[minIndex]){
                   minIndex=j;
               }
           }
           int tmp=array[i];
           array[i]=array[minIndex];
           array[minIndex]=tmp;
       }
    }
}
