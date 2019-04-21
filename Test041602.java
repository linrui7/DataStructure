package com.github7;
/*
    用两个栈实现队列
    Name:  linrui
    Date: 2019/4/16
*/

import java.util.Stack;

public class Test041602 {
    //思路：队列是先进先出，栈是先进后出
    //用两个栈，第一个栈是入，第二个出
    //第一个 进入的顺序是123再讲123入栈到第二个中就是321.实现了先进先出
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    //入队列
    void push(int v){
        //首先要将stack2中的元素放入stack1中，然后新来的元素才能在顶上
        while(!stack2.isEmpty()){
            stack1.push(stack2.peek());
            stack2.pop();
        }
        //放入stack1的顶
        stack1.push(v);
        System.out.println(stack1.peek()+"入队");
    }
    //出队列
    int pop(){
        //首先要将所有元素都放入到stack2中。这样才能保证，最后进入的元素在stack最底下。出栈出的是先来的
        while (!stack1.isEmpty()){
            stack2.push(stack1.peek());
            stack1.pop();
        }
        return stack2.pop();
    }
}
