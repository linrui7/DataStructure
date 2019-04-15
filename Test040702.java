package com.gitee7;
/*
    给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
如果有两个中间结点，则返回第二个中间结点。
    Name:  linrui
    Date: 2019/4/7
*/

public class Test040702 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode(ListNode head) {
        if(head==null){
            return null;
        }
        //定义两个快慢引用。慢的走一步，快的走两步
        ListNode fast = head;
        ListNode slow = head;
        //直到快的为空，说明慢的已经到达了中间位置
        while (fast!= null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
