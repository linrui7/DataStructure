package com.gitee7;
/*
    反转一个单链表
    Name:  linrui
    Date: 2019/4/7
*/

public class Test040701 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        //另一个空链表
        ListNode result = null;
        //找到原链表头
        ListNode cur = head;
        //当前值下一个为原来的head，  当前的值变为现在的head
        while (cur != null) {
            ListNode old = cur.next;
            cur.next = result;
            result = cur;
            cur = old;
        }
        return result;
    }

    // 1 2 3 4 5
    // 5 4 3 2 1 result
    public ListNode reverse(ListNode head) {
        ListNode result = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            if (result == null) {
                result = cur;
            } else {
                cur.next=result;
                result=cur;
                cur=next;
            }
        }
        return result;
    }
}
