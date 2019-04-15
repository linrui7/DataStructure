package com.gitee7;
/*
    给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    Name:  linrui
    Date: 2019/4/11
*/

public class Test0401101 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode getheadClycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //首先判断特殊情况。当链表的头为空时，以及它没有next。next时
        if (slow == null || slow.next == null || slow.next.next == null) {
            return null;
        }
        //判断是否有环，如果没有环，那么fast||fast.next.next肯定会为空
        //如果有环，那么慢节点总会追上快节点，这个时候将快节点赋值为头结点，慢节点不变。
        //慢节点下一次和快节点相遇时，并且此时慢节点是指向刚进入的节点
        while (slow != null && fast.next.next != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                slow = slow.next;
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        System.out.println(getheadClycle(node1).val);
    }
}
