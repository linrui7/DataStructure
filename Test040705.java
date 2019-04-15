package com.gitee7;
/*
    编写代码，以给定值x为基准将链表分割成两部分
    所有小于x的结点排在大于或等于x的结点之前
    注意：分割以后保持原来的数据顺序不变。
    eg：
    输入{3,3,3}3
    输出3,3,3
    Name:  linrui
    Date: 2019/4/7
*/

public class Test040705 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode partition(ListNode pHead, int x) {

        ListNode large = null;
        ListNode small = null;
        ListNode largelast = null;
        ListNode smalllast = null;
        ListNode cur = pHead;

        //如果给的链表为空，直接返回空
        if (cur == null) {
            return null;
        }
        //如果不为空。遍历链表，小于val和大于val的分别存放在链表中
        while (cur != null) {
            if (cur.val < x) {
                ListNode old = cur.next;
                cur.next = null;
                if (small == null) {
                    small = cur;
                    smalllast = small;
                } else {
                    smalllast.next = cur;
                    smalllast = cur;
                }
                cur = old;
            } else {
                ListNode old = cur.next;
                cur.next = null;
                if (large == null) {
                    large = cur;
                    largelast = cur;
                } else {
                    largelast.next = cur;
                    largelast = cur;
                }
                cur = old;
            }
        }
        //根据以上代码 已经将两个链表存好
        //如果val包含在节点中，则将小的最后一个连接到大的头节点上
        //如果所有值都小于给定的val 则直接返回小的
        //如果给定的值都大于等于val 则直接返回大的
        if (large != null && small != null) {
            smalllast.next = large;
            return small;
        } else if (small == null) {
            return large;
        } else {
            return small;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(0);
        ListNode listNode = partition(node1, 3);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
