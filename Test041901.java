package com.github7;
/*
    二叉树的前序中序后序遍历  递归实现
    Name:  linrui
    Date: 2019/4/19
*/

public class Test041901 {
    class Node {
        char value;
        Node left;
        Node right;

        Node(char v) {
            this.value = v;
        }
    }

    //二叉树遍历  先序遍历
    private static void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.println(root.value + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    //二叉树遍历  中序遍历
    void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.value + " ");
            inOrderTraversal(root.right);
        }
    }

    //二叉树遍历  后序遍历
    void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.value + " ");
        }
    }
}
