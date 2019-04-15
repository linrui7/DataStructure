package com.gitee7;
/*
    对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。
    Name:  linrui
    Date: 2019/4/8
*/

public class Test040801 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //获取链表长度的函数
    public static int getlength(ListNode node) {
        ListNode cur = null;
        cur = node;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

    //反转后半截节点的函数
    public static ListNode reserve(ListNode head) {
        ListNode cur = head;
        ListNode result = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            if (result == null) {
                result = cur;
            } else {
                cur.next = result;
                result = cur;
            }
            cur = next;
        }
        return result;
    }

    public static boolean chkPalindrome(ListNode A) {

        //首先获取到中间节点的位置
        int middlelength = getlength(A) / 2;
        ListNode middle = A;
        for (int i = 0; i < middlelength; i++) {
            middle = middle.next;
        }
        //找到中间节点的位置之后，将中间之后的节点进行反转
        ListNode mid = reserve(middle);
        while (mid != null) {

         //反转之后和原来的进行比对
              if (mid.val != A.val) {
                return false;
            }
            mid = mid.next;
            A = A.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        System.out.println(chkPalindrome(node2));

    }
}
