package com.github7.Tree;
/*
   Author:linrui
   Date:2019/8/9
   Content:判断两棵树是否相同。
*/

public class TheSameTree {
    class Node {
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

    boolean isSameTree(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
}
