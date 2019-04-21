package com.gitee7;
/*
    队列的简单操作
    Name:  linrui
    Date: 2019/4/13
*/

public class MyQueue {
    static class Node {
        int value;
        Node next;
    }

    Node head;
    Node last;

    MyQueue() {
        this.head = this.last = null;
    }

    //插入数据  插到队伍
    void push(int v) {
        Node node = new Node();
        node.value=v;
        node.next = null;
        if (head == null) {
            //如果为空，node作为头，node 也是尾
            head = node;
            last = node;
        } else {
            //插入到队列，最后的下一个是新的，新的编程最后一个
            last.next = node;
            last = node;
        }
    }

    //出队列 返回移除的元素
    int pop() {
        int oldhead = head.value;
        //把头除去，头的下一个作为新的头
        head = head.next;
        if (head == null) {
            last = null;
        }
        return oldhead;
    }

    //返回队首元素
    int frount() {
        return head.value;
    }

    //判断是否为空
    boolean isEmpty() {
        return head == null;
    }
    public static void main(String[] args) {
        MyQueue myQueue=new MyQueue();
        System.out.println(myQueue.isEmpty());
        System.out.println();
        myQueue.push(30);
        myQueue.push(15);
        myQueue.push(20);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.frount());
    }
}
