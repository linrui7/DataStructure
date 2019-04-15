package com.gitee7;
/*
    栈的简单操作
    Name:  linrui
    Date: 2019/4/13
*/

public class MyStack {
    private int top;
    private int[] array;
    MyStack(){
        this.top=0;
        this.array=new int[100];
    }

    //是否为空
    boolean isEmpty(){
        return this.top==0;
    }
    //压栈
    void push(int value){
        array[top++]=value;
        System.out.println("栈顶压入"+value);
    }
    //出栈
    int top(){
        return array[--top];
    }
    //查看栈顶元素
    int peek(){
        return array[top-1];
    }
    //查看栈高度
    int size(){
        return top;
    }

    public static void main(String[] args) {
        MyStack myStack=new MyStack();
        System.out.println(myStack.isEmpty());
        System.out.println();
        myStack.push(30);
        myStack.push(15);
        myStack.push(20);
        System.out.println(myStack.peek());
        System.out.println(myStack.top);
    }


}
