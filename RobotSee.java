/*
   Author:linrui
   Date:2019/9/8
   Content:
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RobotSee{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int robotCount = scanner.nextInt();
        int[] array = new int[robotCount];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            if(array[i]<=0){
                return;
            }
        }
        print(robotCount, array);
    }

    private static void print(int robotCount, int[] array) {
        if (robotCount < 2) {
            return;
        }

        if (robotCount ==2) {
            System.out.println(array[0]);
            return;
        }
        //此处可能存在问题。如果有两个身高相同的 共享统一key。
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], 0);
        }
        for (int i = 0; i < array.length - 1; i++) {
            int max = array[i + 1];
            //如果key相同，重新从0往上加，如果不大于原来的，将其替换为原来的。
            //但是第一个遇到的最大的会变。。
            for (int j = i + 1; j < array.length; j++) {
                //  3  1  2  1
                if (j == i + 1) {
                    map.put(array[i], map.get(array[i]) + 1);
                }
                if (array[j] > max) {
                    map.put(array[i], map.get(array[i]) + 1);
                    max = array[j];
                }
            }
        }

        //找到最大的值
        int max = 0;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) > max) {
                max = map.get(array[i]);
                index = i;
            }
        }
        System.out.println(array[index]);
    }
}
