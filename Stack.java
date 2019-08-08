package com.github7.QueueAndStack;

import java.util.LinkedList;

/*
   Author:linrui
   Date:2019/8/8
   Content:实现一个栈
   先进后出

*/
class TwoQueueToStack {
    LinkedList<Integer> queueA = new LinkedList<>();
    LinkedList<Integer> queueB = new LinkedList<>();

    //入栈
    void push(int value) {
        while (queueB != null) {
            queueA.push(queueB.poll());
        }
        queueA.push(value);
    }

    //出栈  栈顶元素移除
    int pop() {
        int head = 0;
        int last = queueA.getLast();
        while (head != last) {
            head = queueA.getFirst();
            queueB.push(queueA.poll());
        }
        queueA.pop();
        return last;
    }
}

public class Stack {
    private int top = 0;
    private int[] array = new int[100];

    public Stack() {
        this.top = top;
        this.array = array;
    }


    //入栈
    void push(int value) {
        array[top++] = value;
    }

    //出栈
    int pop() {
        return array[top--];
    }

    //查看栈顶元素
    int peek() {
        return array[top - 1];
    }

    //栈是否为空
    boolean isEmpty() {
        return this.top == 0;
    }
}
