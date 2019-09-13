/*
   Author:linrui
   Date:2019/9/11
   Content:
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Num {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int num=scanner.nextInt();
            print(num);
        }
    }

    private static void print(int num) {
        if(num<=0||num>5050){
            return;
        }
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        for(int i=1;i<101;i++){
            sum+=i;
            map.put(i,sum);
        }
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(m.getValue()==num){
                System.out.print(m.getKey());
                return;
            }
        }
        System.out.print("No");
    }
}
