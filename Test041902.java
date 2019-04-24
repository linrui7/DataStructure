package com.github7;
/*
    二叉树经典题目
    Name:  linrui
    Date: 2019/4/19
*/

public class Test041902 {
    static class Node {
        char value;
        Node left;
        Node right;

        Node(char v) {
            this.value = v;
        }
    }

    //一棵二叉树有多少个节点
    static int count = 0;

    static int countBinaryTree(Node root) {
        if (root != null) {
            countBinaryTree(root.left);
            countBinaryTree(root.right);
            count++;
        }
        return count;
    }

    //一棵二叉树有多少个节点
    static int count(Node root) {
        if (root == null) {
            return 0;
        } else {
            return count(root.left) + count(root.right) + 1;
        }
    }

    //求二叉树的深度
    static int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            int left = height(root.left);
            int right = height(root.right);
            if (left > right) {
                return left + 1;
            } else {
                return right + 1;
            }
        }
    }

    private static Node createTestTree() {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.right = h;
        return a;
    }

    public static void main(String[] args) {
        Node root = createTestTree();
        System.out.println(count(root));
        System.out.println(countBinaryTree(root));
    }
}
