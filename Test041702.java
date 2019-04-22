package com.github7;
/*
    实现一个最小栈
    Name:  linrui
    Date: 2019/4/17
*/

import java.util.Stack;

public class Test041702 {
    class minStack{
        Stack<Integer> stackAll=new Stack();
        Stack<Integer> stackMin=new Stack();

        //入栈操作，最小栈不为空，对比当前值，如果当前值小于或者等于，那就给最小栈入栈
        void push(int v){
            stackAll.push(v);
            if(stackMin.isEmpty()){
                stackMin.push(v);
            }else if(stackMin.peek()>v){
                stackMin.push(v);
            }else{
                stackMin.push(stackMin.peek());
            }
        }
        //出栈，如果最小栈中的顶刚好是出栈的数，那么也要出栈
        void pop(){
            if(stackAll.peek()==stackMin.peek()){
                stackMin.pop();
            }
            stackAll.pop();
        }
        int top(){
            return  stackAll.peek();
        }
        //获取最小元素
        int getMin(){
            return stackMin.peek();
        }
    }

}
