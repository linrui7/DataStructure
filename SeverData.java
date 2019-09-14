/*

 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SeverData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();//保存每次最大并行传输个数
        if(k<=0){
            System.out.println(0);
            return;
        }
        int line = scanner.nextInt();//保存行数
        if(line<=0){
            System.out.println(0);
            return;
        }
        Map<Integer, int[]> lines = new HashMap<>();
        //保存每一行的数组
        for (int i = 0; i < line; i++) {
            int length = scanner.nextInt();
            int[] array = new int[length];
            for (int j = 0; j < length; j++) {
                array[i] = scanner.nextInt();
                if(array[i]>=100000){
                    return;
                }
            }
            lines.put(i, array);
        }
        //求二叉树高度以及 最大数量的层


    }
}
