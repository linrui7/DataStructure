package com.gitee7;
/*
    编写一个程序，找到两个单链表相交的起始节点。
    Name:  linrui
    Date: 2019/4/8
*/

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

public class Test040802 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0;
        int lenB = 0;
        //计算A的长度
        while (cur1 != null) {
            lenA++;
            cur1 = cur1.next;
        }
        //计算B的长度
        while (cur2 != null) {
            lenB++;
            cur2 = cur2.next;
        }

        //长的链表先走length步
        int length = 0;
        if (lenA > lenB) {

            //如果A比B长，A先走A-B部。然后一起走，直到相等或者为空
            length = lenA - lenB;
            for (int i = 0; i < length; i++) {
                curA = curA.next;
            }
            while (curA != null && curB != null) {
                if (curA.next == curB.next) {
                    return curA.next;
                }
                curA = curA.next;
                curB = curB.next;
            }
        } else {
            //如果B比A长，B先走B-A步。然后一起走，直到相等或者为空
            length = lenB - lenA;
            for (int i = 0; i < length; i++) {
                curB = curB.next;
            }
            while (curA != null && curB != null) {
                if (curA.next == curB.next) {
                    return curA.next;
                }
                curA = curA.next;
                curB = curB.next;
            }
        }
        return cur1;
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
        System.out.println(getIntersectionNode(node6, node6));

    }
}