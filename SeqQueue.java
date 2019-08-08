package com.github7.QueueAndStack;
/*
   Author:linrui
   Date:2019/8/8
   Content:数组实现一个循环队列
*/

class ReQueue {
    Object[] queue;
    int head;
    int last;
    int lenth;

    ReQueue(int lenth) {
        this.lenth = lenth;
        queue = new Object[lenth + 1];
        head = last = 0;
    }

    //判断是否为满
    boolean isFull() {
        if (head == (last + 1)%lenth) {
            return true;
        } else {
            return false;
        }
    }

    //判断是否为空
    boolean isEmpty() {
        if (head == last) {
            return true;
        } else {
            return false;
        }
    }

    //插入元素 成功则返回true
    boolean enQueque(int value) {
        if (isFull()) {
            return false;
        } else {
            queue[last] = value;
            last = (last + 1) % lenth;
            return true;
        }
    }

    //删除头元素 删除成功返回true 删除失败返回false
    boolean delQueuehead(){
        if (isEmpty()) {
            return false;
        }else {
            head=(head+1)%lenth;
            return true;
        }
    }
    //获取队首元素
    Object Front(){
        if(isEmpty()){
            return null;
        }else {
            return head;
        }
    }

}

public class SeqQueue {
}
