package com.github7;
/*
    循环队列的实现
    Name:  linrui
    Date: 2019/4/18
*/

public class Test041801 {
    //建立一个循环队列。
    //定义一个开头，和一个尾。
    //如果头和尾指向同一个位置时，无法判断是空还是满。
    //所以就要牺牲一个位置，当空的位置的next=头，那么满了
    /*MyCircularQueue(k): 构造器，设置队列长度为 k 。
    Front: 从队首获取元素。如果队列为空，返回 -1 。
    Rear: 获取队尾元素。如果队列为空，返回 -1 。
    enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
    deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
    isEmpty(): 检查循环队列是否为空。
    isFull(): 检查循环队列是否已满。
    */
    Object[] queue;
    int head;
    int tail;
    int length;

    public Test041801(int k) {
        queue = new Object[k + 1];
        length = k + 1;
        head = tail = 0;
    }

    //enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            queue[tail] = value;
            tail = (tail + 1) % length;
            return true;
        }
    }

    //deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            head = (head + 1) % length;
            return true;
        }
    }

    //Front: 从队首获取元素。如果队列为空，返回 -1 。
    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return head;
        }
    }

    //Rear: 获取队尾元素。如果队列为空，返回 -1 。
    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            return tail;
        }
    }
    public boolean isEmpty() {
        if (head == tail) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isFull() {
        if (tail + 1 == head) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
