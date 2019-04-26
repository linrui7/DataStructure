package com.github7;
/*
    在二叉树中找值
    Name:  linrui
    Date: 2019/4/20
*/

public class Test042001 {
    static class Node {
        char value;
        Node left;
        Node right;

        Node(char v) {
            this.value = v;
        }
    }

    //找到值为v的节点
    Node find(Node root, char v) {
        if (root == null) {
            return null;
        } else if (root.value == v) {
            return root;
        } else if (find(root.left, v) != null) {
            return find(root.left, v);
        } else if (find(root.right, v) != null) {
            return find(root.right, v);
        } else {
            return null;
        }
    }

    Node find2(Node root, char v) {
        if (root == null) {
            return null;
        }
        if (root.value == v) {
            return root;
        }
        Node val = find2(root.left, v);
        if (val != null) {
            return val;
        }
        val = find2(root.right, v);
        if (val != null) {
            return val;
        }
        return null;
    }
}
