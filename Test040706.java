package com.gitee7;
/*
    在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    Name:  linrui
    Date: 2019/4/7
*/

public class Test040706 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //   dummy->1->2->3->3->4->4->5
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        //prev是p1的前驱节点
        ListNode prev = dummy;
        ListNode p1 = pHead;
        ListNode p2 = pHead.next;
        while (p2 != null) {
            //判断p1的值不等于p2的值。两个引用都指向下一节点
            if (p1.val != p2.val) {
                prev = prev.next;
                p1 = p1.next;
                p2 = p2.next;
            } else {
                //如果p2=p1，那么p2一直指向下一节点，直到不相等或者为空
                //这个时候p1----p2之间的内容都要删除。所以p1的前驱节点指向p2,p1现在走到p2的位置，p2向后移
                while (p2 != null && p2.val == p1.val) {
                    p2 = p2.next;
                }
                prev.next = p2;
                p1 = p2;
                //然后p1此时移动到p2的位置，p2向后移动。
                //刚刚移动过程中，p2可能已经为空，所以这个时候要判断
                if (p2 != null) {
                    p2 = p2.next;
                }
            }
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        ListNode node = deleteDuplication(node3.next);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }


    }
}
