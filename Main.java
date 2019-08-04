package com.github7;
/*
   Author:linrui
   Date:2019/8/4
   Content:
*/

import javafx.print.Collation;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //ArrayList实现
        List<String> stringArrayList=new ArrayList<>();
        stringArrayList.add("ArrayList 的第一个元素");
        stringArrayList.add("ArrayList 的第2个元素");
        stringArrayList.add("ArrayList 的第2个元素");
        System.out.println(stringArrayList);
        stringArrayList.add("ABC");
        stringArrayList.add("hello");
        System.out.println(stringArrayList.isEmpty());
        System.out.println(stringArrayList.get(1));
        System.out.println(stringArrayList.contains("ABC"));
        for(int i=0;i<stringArrayList.size();i++){
            System.out.println("元素为"+ stringArrayList.get(i));
        }

        //Vector实现
        List<String >  stringVector=new Vector<>();
        stringVector.add("hello");
        stringVector.add("aaa");
        stringVector.add("aaa");
        System.out.println(stringVector);

        //LinkedList实现
        List<String >  stringList=new LinkedList<String>();
        stringList.add("ABC");
        ((LinkedList<String>) stringList).addLast("ABC");
        stringList.add("ABC");
        System.out.println(stringList);

        //HashSet实现
        Set<String>  stringSet=new HashSet<>();
        stringSet.add("ABC");
        stringSet.add("ABC");
        stringSet.add("AAA");
        stringSet.add("AA");
        stringSet.add("C");
        stringSet.add("C");
        stringSet.add("B");
        System.out.println(stringSet);

        //迭代器输出
        //实例化Iterator对象
        Iterator<String > iterator=stringArrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //实例化Iterator对象
        Iterator<String > iterator1=stringArrayList.iterator();
        while (iterator1.hasNext()){
            if(iterator1.next().equals("ABC")){
                iterator.remove();
                //使用Iterator的remove方法则不会产生异常
                continue;
            }
            System.out.println(iterator1.next());
        }

        ListIterator<String >  iterator2=stringArrayList.listIterator();
        while (iterator2.hasPrevious()){
            System.out.println(iterator2.previous());
        }
    }
}
