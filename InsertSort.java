/*
   Author:linrui
   Date:2019/8/17
   Content: 直接插入排序
   本方法是将数组分为两块儿，一部分是有序，一部分是无序的。
   每次选取有序队列后面的那个数，插入到有序队列中。然后其他元素后移
   //3,1,5,7,2,4,9,6
*/

public class InsertSort {
    public void insertSort(int[] array){
        for(int i=1;i<array.length;i++){
            int tmp=array[i];
            //寻找array[i]应该到的下标位置,然后向前走
            int j;
            for(j=i-1;j>=0&&array[j]>tmp;j--){
                array[j+1]=array[j];
            }
            //交换完毕，插入tmp
            array[j+1]=tmp;
        }
    }
}
