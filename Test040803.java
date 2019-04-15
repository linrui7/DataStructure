package com.gitee7;
/*
    给定一个链表，判断链表中是否有环。
    Name:  linrui
    Date: 2019/4/8
*/

public class Test040803 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //首先判断简单的情况。链表为空的情况，只有一个不是自环的节点，和只有两个不是环的节点
        if (slow == null || slow.next == null || slow.next.next == null) {
            return false;
        }

        //采用快慢引用的方法。快的走的两步，慢的走一步，但是如果有环，慢的总会遇到快的。
        while (slow != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        System.out.println(hasCycle(node1));

    }
}
