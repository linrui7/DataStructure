package com.github7.QueueAndStack;
/*
   Author:linrui
   Date:2019/8/9
   Content:
   设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
*/

import java.util.Stack;

class MinStackDemo {
    Stack<Integer> stackMin = new Stack<>();
    Stack<Integer> stackAll = new Stack<>();

    //入栈 和最小栈里面的元素比较，如果是小的就进小的和全部。如果不是，只进去全部
    void push(int value) {
        stackAll.push(value);
        if (stackMin.empty()) {
            stackMin.push(value);
        } else {
            if (stackMin.peek() > value) {
                stackMin.pop();
                stackMin.push(value);
            }else if(stackMin.peek()==value){
                stackMin.push(value);
            }
        }
    }

    //出栈
    void pop(){
          if(stackAll.peek()==stackMin.peek()){
              stackMin.pop();
              stackAll.pop();
          }else {
              stackAll.pop();
          }
    }
    //最顶上元素
    int peek(){
        return stackAll.peek();
    }
    //最小值
    int getMIn(){
        return stackMin.peek();
    }

}

public class MinStack {
    public static void main(String[] args) {

    }
}
