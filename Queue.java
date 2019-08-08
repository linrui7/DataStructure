package com.github7.QueueAndStack;
/*
   Author:linrui
   Date:2019/8/8
   Content:实现一个队列
*/

import java.util.Stack;

//用链表实现一个队列
class ListQueue {
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    Node head = null;
    Node last = null;

    public ListQueue() {
        this.head = head;
        this.last = last;
    }

    //入队尾
    void push(int val) {
        Node node = new Node(val);
        node.next = null;
        if (head == null) {
            head = node;
            last = head;
        } else {
            last.next = node;
            last = node;
        }
    }

    //出队头,返回删除的元素值
    int pop() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            last = null;
        }
        return val;
    }

    //返回队首元素
    int frount() {
        return this.head.value;
    }

    //判断是否为空
    boolean isEmpty() {
        return head == null;
    }
}

//用两个栈实现一个队列
class TwoStackToQueue {
    Stack<Integer> stackA = new Stack();
    Stack<Integer> stackB = new Stack();

    //入队尾
    void push(int value) {
        while (stackB != null) {
            stackA.push(stackB.pop());
        }
        stackA.push(value);
    }

    //出队头
    int pop() {
        while (stackA != null) {
            stackB.push(stackA.pop());
        }
        return stackB.pop();
    }

    //判断是否为空
    boolean isEmpty() {
        return stackB.empty() && stackA.empty();
    }

    //返回队首元素
    int peek() {
        while (stackA != null) {
            stackB.push(stackA.pop());
        }
        return stackB.peek();
    }

}

public class Queue {

}
