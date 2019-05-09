package com.github7;
/*
    判断两颗二叉树是否相同
*/

public class BinaryTree {

    class Node {
        char val;
        Node right;
        Node left;
        Node root;

        public Node(char val) {
            this.val = val;
            this.right = right;
            this.left = left;
            this.root = root;
        }
    }

    boolean isSame(Node root1, Node root2) {
        //如果两棵树都为空
        if (root1 == null && root2 == null) {
            return true;
        }
        //其中一棵树为空
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1 != null && root2 != null) {
            if (root1.val != root2.val) {
                return false;
                //如果root的值相等，那么继续判断他的左右孩子是否相等
            } else {
                return isSame(root1.left,root2.left)&&isSame(root1.right,root2.right);
            }
        }
        return false;
    }
}
