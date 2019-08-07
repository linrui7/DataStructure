package com.github7.SequentialAndLinkedList;
/*
   Author:linrui
   Date:2019/8/7
   Content:链表题目集合
*/


public class ListMain {

    public static class ListNode {
        int value;
        ListNode next;
        ListNode random;
        ListNode(int x) {
            this.value = x;
        }
        ListNode(int x,ListNode next,ListNode random){
            this.value=x;
            this.next=next;
            this.random=random;
        }
    }

    //删除链表中等于给定值 val 的所有节点。
    public static ListNode removeElement(ListNode head, int val) {
        //1.创建一个新的链表
        //2.遍历原链表
        //3.对新链表进行尾插
        ListNode result = null;
        ListNode last = null;

        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            //如果值不相等，继续往后找
            if (current.value != val) {
                current.next = null;
                if (result == null) {
                    result = current;
                    last = current;
                } else {
                    last.next = current;
                    last = current;
                }
            }
            current = next;
        }
        return result;
    }

    //删除链表中等于给定值 val 的所有节点。
    public ListNode removeElement2(ListNode head, int val) {
        //在原链表上直接删除
        if (head == null) {
            return null;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.next.value != val) {
                current = current.next;
            } else {
                current.next = current.next.next;
            }
        }
        if (head.value == val) {
            return head.next;
        }
        return head;
    }

    //反转一个单链表
    public ListNode reserveList(ListNode head) {
        //重新创建一个链表，将原来的链表进行头插
        ListNode result = null;
        ListNode current = head;
        //遍历原链表
        while (current != null) {
            ListNode next = current.next;
            current.next = null;
            if (result == null) {
                result = current;
                current = next;
            } else {
                current.next = result;
                result = current;
                current = next;
            }
        }
        return result;
    }

    // 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
    public ListNode middleNode(ListNode head) {
        //快慢指针法
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //输入一个链表，输出该链表中倒数第k个结点。
    public ListNode findLastK(ListNode head, int k) {
        //首先判断这个链表有没有K个节点
        int length = 0;
        ListNode current = head;
        ListNode slow = head;
        ListNode fast = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        if (length < k) {
            return null;
        } else if (length == k) {
            return head;
        } else {
            //如果长度大于k，用快慢指针法。快的先走K步，然后慢的和快的一起开始走
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }

    // 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode currentA = head1;
        ListNode currentB = head2;
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        } else {
            //如果两个链表都不为空的情况下。

            ListNode result = null;
            ListNode last = null;
            while (currentA != null && currentB != null) {
                if (currentA.value < currentB.value) {
                    ListNode nextA = currentA.next;
                    currentA.next = null;
                    //尾插
                    if (result == null) {
                        result = currentA;
                        currentA = nextA;
                    } else {
                        last.next = currentA;
                        last = currentA;
                        currentA = nextA;
                    }
                } else {
                    ListNode nextB = currentB.next;
                    currentB.next = null;
                    //尾插
                    if (result == null) {
                        result = currentB;
                        currentB = nextB;
                    } else {
                        last.next = currentB;
                        last = currentB;
                        currentB = nextB;
                    }
                }
            }

            //对比尾插结束，其中有一个链表已经为空。直接尾插到结果链表上
            if (currentA == null) {
                last.next = currentA;
            } else {
                last.next = currentB;
            }
            return result;
        }
    }

    //给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public static ListNode splitX(ListNode head, int x) {
        //定义两个链表，一个是全小于X的，一个是全部大于等于X的，然后将其拼接在一起就是结果链表
        ListNode small = null;
        ListNode large = null;
        ListNode smallLast = null;
        ListNode largeLast = null;
        if (head == null) {
            return null;
        }
        ListNode current = head;
        while (current != null) {
            if (current.value < x) {
                ListNode next = current.next;
                current.next = null;
                if (small == null) {
                    small = current;
                    smallLast = current;
                    current = next;
                } else {
                    smallLast.next = current;
                    smallLast = current;
                    current = next;
                }
            } else {
                ListNode next = current.next;
                current.next = null;
                if (large == null) {
                    large = current;
                    largeLast = current;
                    current = next;
                } else {
                    largeLast.next = current;
                    largeLast = current;
                    current = next;
                }
            }
        }

        System.out.println();

        //分区完毕，开始组合
        if (large != null && small != null) {
            smallLast.next = large;
            return small;
        } else if (small == null) {
            return large;
        } else {
            return small;
        }
    }

    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    public ListNode delSameNode(ListNode head) {
        if (head == null) {
            return null;
        }
        //不为空的情况下
        //重新定义一个头结点。避免所有的都是空，空的下一个也为null
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;
        ListNode currentnext = head.next;
        while (currentnext != null) {
            if (current.value != currentnext.value) {
                prev = prev.next;
                current = current.next;
                currentnext = currentnext.next;
            } else {
                //如果current和它的下一个相等，那么继续寻找,直到为空或者值不相同
                while (currentnext != null && currentnext.value == current.value) {
                    currentnext = currentnext.next;
                }
                //找到了值不相同的。
                prev.next = currentnext;
                current = currentnext;
                //不相同并且不为空。
                if (currentnext != null) {
                    currentnext = currentnext.next;
                }
            }
        }
        return dummy.next;
    }

    //给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。
    class ChkPalindrome {
        public boolean isPalindrome(ListNode head) {
            //首先获取链表长度
            int len = 0;
            ListNode current = head;
            while (current != null) {
                len++;
                current = current.next;
            }
            len /= 2;
            //反转后半截链表
            current = head;
            for (int i = 0; i < len; i++) {
                current = current.next;
            }
            ListNode lastmid = reserve(current);
            //对比反转之后的和原来的
            while (lastmid != null) {
                if (lastmid.value != head.value) {
                    return false;
                }
                lastmid = lastmid.next;
                head = head.next;
            }
            return true;
        }

        public ListNode reserve(ListNode head) {
            ListNode current = head;
            ListNode result = null;
            //遍历原链表，进行头插。
            while (current != null) {
                ListNode next = current.next;
                current.next = null;
                if (result == null) {
                    result = current;
                    current = current.next;
                } else {
                    current.next = result;
                    result = current;
                    current = next;
                }
            }
            return result;
        }
    }

    //找到两个单链表相交的起始节点。
    //如果相交。说明他们公共部分一样长，所以求长度差，然后再对比。
    public ListNode sameNode(ListNode headA, ListNode headB) {
        ListNode current1 = headA;
        ListNode current2 = headB;
        int lenA = 0;
        int lenB = 0;
        while (current1 != null) {
            lenA++;
            current1 = current1.next;
        }
        while (current2 != null) {
            lenA++;
            current2 = current2.next;
        }
        ListNode currentA = headA;
        ListNode currentB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                currentA = currentA.next;
            }
            while (currentA != null && currentB != null) {
                //地址引用相同。
                if (currentA.next == currentB.next) {
                    return currentA.next;
                }
                //同时往后走一步。
                currentA = currentA.next;
                currentB = currentB.next;
            }
        } else {
            //B 比 A长。B先走。
            for (int i = 0; i < lenB - lenA; i++) {
                currentB = currentB.next;
            }
            while (currentA != null && currentB != null) {
                //地址引用相同。
                if (currentA.next == currentB.next) {
                    return currentA.next;
                }
                //同时往后走一步。
                currentA = currentA.next;
                currentB = currentB.next;
            }
        }
        return currentA;
    }

    //给定一个链表，判断链表中是否有环。
    public boolean isCircle(ListNode head) {
        //定义快慢指针法。
        ListNode slow = head;
        ListNode fast = head;
        if (slow == null || slow.next == null || slow.next.next == null) {
            return false;
        }
        while (slow != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 NULL
    public ListNode circle(ListNode head) {
        //采用快慢指针法
        ListNode slow = head;
        ListNode fast = head;
        if (slow == null || slow.next == null || slow.next.next == null) {
            return null;
        }
        //判断有环的情况下
        while (slow != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //有环相遇时，将快的置为head。同时向后移动，两个会相遇。
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    //给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
    //要求返回这个链表的深拷贝。
    public ListNode copyRandomList(ListNode head) {
        if (head == null) {
            return null;
        }
        //开始拷贝。
        //1.首先复制一份原链表在后面
        ListNode current = head;
        while (current != null) {
            ListNode newNode = new ListNode(current.value);
            newNode.next = current.next;
            current.next = newNode;
            current = current.next.next;
        }
        //拷贝原数组完成。现在开始将newNode 加上随机指向。
        current=head;
        while (current!=null){
            ListNode newNode=current.next;
            if(current.random==null){
                newNode.random=null;
            }else {
                //如果原指向不为空。那么它指向随机值的copy值
                newNode.random=current.random.next;
            }
            current=current.next.next;
        }
        //随机值添加完毕，现在开始拆分。
        //2-4-6 偶数值为深拷贝之后的
        current=head;
        //定义新链表的头结点
        ListNode result=current.next;
        while (current!=null){
            //定义新链表的current为newNode
            ListNode newNode=current.next;
            ListNode nextnext=current.next.next;
            if(newNode.next!=null){
                newNode.next=newNode.next.next;
            }
            current=nextnext;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(20);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(15);
        ListNode node4 = new ListNode(12);
        ListNode node5 = new ListNode(30);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode listNode = splitX(node1, 15);
        while (listNode != null) {
            System.out.print(listNode.value + " ");
            listNode = listNode.next;
        }
    }
}
