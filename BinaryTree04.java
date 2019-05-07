package com.github7;
/*
    求第K层节点的个数
    如果proot为空，或者层数k_Level <= 0，则为空树或者不合要求，则返回0；
    如果root不为空，且此时层数 k_Level==1，则此时root为第K层节点之一，则返回1；
    如果root不为空，且此时层数 k_Level > 1，则此时需要求root左子树（k_Level - 1 ）层节点数和root右子树（k_Level-1）层节点数；

*/

import javax.swing.*;

public class BinaryTree04 {
    static class Node {
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

    public static int K_Level_count(Node root, int k) {

        //如果当前k层没有数，返回0个个数
        if (root == null) {
            return 0;
        }
        //如果此时root不为空，此时root为第K层节点之一
        if (root != null && k == 1) {
            return 1;
        }
        return K_Level_count(root.left,k-1)+K_Level_count(root.right,k-1);
    }

    private static Node createTestTree() {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('F');
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
        System.out.println(K_Level_count(root,3));
    }
}
