package com.gitee7;
/*
    将两个有序链表合并为一个新的有序链表并返回。
    新链表是通过拼接给定的两个链表的所有节点组成的。
    Name:  linrui
    Date: 2019/4/7
*/

import java.util.List;

public class Test040704 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode result = null;
        ListNode resultlast = null;

        //这里有三种情况，依次进行处理
        //1.两个都为空的情况下，直接返回null
        //2.其中一个为null的情况下。返回不为null的
        //3.两个都不为空，进行尾插。一个为空，尾插另一个的全部

        if(cur1==null&&cur2==null){
            return null;
        }else if(cur1==null&&cur2!=null){
            return cur2;
        }else if(cur1!=null&&cur2==null){
            return cur1;
        }

        //两个都不为空的情况下
        while (cur1 != null && cur2 != null) {
            //比大小。小的进行尾插到result的最后一个节点上
            if (cur1.val < cur2.val) {
                ListNode oldcur1 = cur1.next;
                cur1.next = null;
                if (result == null) {
                    result = cur1;
                    resultlast = result;
                } else {
                    resultlast.next = cur1;
                    resultlast = cur1;
                }
                cur1 = oldcur1;
            } else {
                ListNode oldcur2 = cur2.next;
                cur2.next = null;
                if (result == null) {
                    result = cur2;
                    resultlast = result;
                } else {
                    resultlast.next = cur2;
                    resultlast = cur2;
                }
                cur2 = oldcur2;
            }
        }
        //比完大小后，发现其中一个所有的节点都进行了尾插。变成了null
        //则直接将另一个数组的头接到result的最后一个节点上
        if (cur1 == null) {
            resultlast.next = cur2;
        } else {
            resultlast.next = cur1;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(15);
        ListNode node2 = new ListNode(20);
        ListNode node3 = new ListNode(15);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        ListNode node4=new ListNode(2);
        ListNode node5=new ListNode(0);
        ListNode listNode = mergeTwoLists(node4, node3.next);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
