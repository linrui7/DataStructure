package com.github7;

/*
 * 利用带空节点的前序 创建二叉树
 * 1.构造一个类，返回当前使用的节点个数，以及当前是哪个节点
 * 2.递归调用
 * */

import java.util.Arrays;

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

class ReturnRootValue {

    //创建二叉树返回两个参数，当前的root以及已经使用掉的个数
    public Node returnRoot;
    public int used;

    public ReturnRootValue(Node returnRoot, int used) {
        this.returnRoot = returnRoot;
        this.used = used;
    }
}

public class BinaryTree02 {
    //传入给定的字符串数组，进行创建
    public static ReturnRootValue createTree(char[] preOrder) {
        //1.首先判断字符串是否为空，以及是否右子树是空的情况
        if (preOrder.length == 0) {
            //如果为空。说明它不是跟节点，要使用的个数为0
            return new ReturnRootValue(null, 0);
        }
        //2.如果遇到了“#”说明右子树为空，此时只用掉左子树一个节点
        char rootValue = preOrder[0];
        if (rootValue == '#') {
            return new ReturnRootValue(null, 1);
        }
        //3.如果不为空则创建跟节点
        Node root = new Node(rootValue);
        //4.创建左子树，去掉第一个值
        char[] leftPreOrder = new char[preOrder.length - 1];
        leftPreOrder = Arrays.copyOfRange(preOrder, 1, preOrder.length);
        ReturnRootValue leftReturn = createTree(leftPreOrder);
        //5.创建右子树,去掉跟和左子树用掉的
        char[] rightPreOrder = new char[preOrder.length - leftReturn.used - 1];
        rightPreOrder = Arrays.copyOfRange(preOrder, leftReturn.used + 1, preOrder.length);
        ReturnRootValue rightReturn = createTree(rightPreOrder);
        //6.将左右子树绑定到跟上 创建好的树的根结点是 root
        root.left=leftReturn.returnRoot;
        root.right=rightReturn.returnRoot;
        //7.此时已经创建好了一棵树,返回使用的总个数
        return new ReturnRootValue(root,1+leftReturn.used+rightReturn.used);
    }
}
