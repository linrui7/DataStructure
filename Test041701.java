package com.github7;
/*
    用两个队列实现栈
    Name:  linrui
    Date: 2019/4/17
*/

import java.util.LinkedList;


public class Test041701 {
    LinkedList<Integer>  queue1=new LinkedList<>();
    LinkedList<Integer>  queue2=new LinkedList<>();

    //用队列 入栈操作
    void push(int v){
        //首先将queue2中的所有元素重新排队到队列1中，再在队列1中插入
        while (!queue2.isEmpty()){
            queue1.push(queue2.getFirst());
            queue2.pollFirst();
        }
        queue1.push(v);
        System.out.println(v+"入栈");
    }

    //用队列 出栈
    int pop(){
        //首先保留queue1中的最后一个元素，将其他元素存放到另一个队列中
        int head=0;
        int last=queue1.getLast();
        while (head!=last){
            last=queue1.getFirst();
            queue2.push(queue1.getFirst());
            queue1.pop();
        }
        return queue1.getLast();
    }


}
