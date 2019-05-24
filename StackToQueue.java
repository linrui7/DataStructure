package com.github7;
/*
   Author:linrui
   Date:2019/5/24
   Content:用两个栈来实现队列
*/

import java.util.Stack;

public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //队列是先进后出。所以。新来的应该在栈底
    public void push(int node) {
        //先将所有stack2中的值放入到stack1中，然后再在stack1中插入
        while (!stack2.isEmpty()) {
            stack1.push(stack2.peek());
            stack2.pop();
        }
        stack1.push(node);
    }

    public int pop() {
//先进的先出。但是此时先进的已经在栈底，所以移动到另一个栈中，再移除栈顶元素
        while (!stack1.isEmpty()){
            stack2.push(stack1.peek());
            stack1.pop();
        }
        return stack2.pop();
    }
}
