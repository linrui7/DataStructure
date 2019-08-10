package com.github7.Tree;
/*
   Author:linrui
   Date:2019/8/9
   Content:
   二叉树
*/

import java.util.Stack;

public class OrderTraversal {
    class Node {
        Node left;
        Node right;
        char value;

        Node(char value) {
            this.value = value;
        }
    }

    //前序遍历 递归
    private static void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.println(root.value + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    //前序遍历，非递归
    private static void preOrderTraversal1(Node root) {
        //先入将根入栈,再入右子树，
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (stack != null) {
            Node node = stack.pop();
            System.out.println(node.value + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
    //前序遍历，非递归
    private static void preOrderTraversal2(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || stack != null) {
            while (cur != null) {
                System.out.println(cur.value);
                stack.push(cur);
                cur = cur.left;
            }
            //左子树打印完毕。回溯打印右子树
            Node huisu = stack.pop();
            cur = huisu.right;
        }
    }

    //中序遍历 递归
    private static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.value + " ");
            inOrderTraversal(root.right);
        }
    }

    //中序遍历，非递归
    private static void inOrderTraversal1(Node root) {
        Node cur = root;
        Stack<Node> stack = new Stack<>();
        while (cur != null || stack != null) {
            while (cur != null) {
                //存入左子树。直到为空才打印他
                stack.push(cur);
                cur = cur.left;
            }
            //存入完毕进行回溯。
            Node huisu = stack.pop();
            System.out.println(huisu.value);
            cur = cur.right;
        }
    }

    //后序遍历 递归
    private static void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.value + " ");
        }
    }

    //后序遍历非递归
    private static void postOrderTraversal1(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node last = null;
        while (stack != null || cur != null) {
            while (cur != null) {
                //存入左子树，直到为空
                stack.push(cur);
                cur = cur.left;
            }
            //存入左子树完毕，开始打印右子树和根
            Node top = stack.peek();
            if (top.right == null) {
                System.out.println(top.value);
                stack.pop();
                last = top;
            } else if (top.right == last) {
                System.out.println(top.value);
                stack.pop();
                last = top;
            } else {
                cur = top.right;
            }
        }
    }
}
