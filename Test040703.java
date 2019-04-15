package com.gitee7;
/*
    输入一个链表，输出该链表中倒数第k个结点。
    Name:  linrui
    Date: 2019/4/7
*/

public class Test040703 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        ListNode cur = head;
        ListNode slow = head;
        ListNode fast = head;
        int length = 0;
        //首先获取到链表的长度
        while (cur != null) {
            length++;
            cur=cur.next;
        }
        //长度如果刚好是K。则倒数第K个结点是头结点
        if (length == k) {
            System.out.println("链表长度length="+length+",k为"+k);
            return slow;
        //如果长度不足K，返回空
        } else if (length < k) {
            System.out.println("链表长度length="+length+",k为"+k);
            return null;
        } else {
         //如果长度大于K,让fast先走K步.慢的从头走。
         //快的到结尾,慢的距离结尾刚好K步。
            for (int j = 0; j < k; j++) {
                fast = fast.next;
            }
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            System.out.println("链表长度length="+length+",k为"+k+"倒数k的值为"+slow.val);
            return slow;
        }
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(15);
        ListNode node2=new ListNode(20);
        ListNode node3=new ListNode(15);
        node1.next=node2;
        node2.next=node3;
        node3.next=null;
        System.out.println(FindKthToTail(node1,2));
    }
}
