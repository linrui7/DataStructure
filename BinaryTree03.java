package com.github7;
/*
 前序和中序创建二叉树
*/

import java.util.Arrays;

public class BinaryTree03 {
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
    int find(char[] array, char v) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == v) {
                return i;
            }
        }

        return -1;
    }
    Node buildTree(char[] preOrder, char[] inOrder) {
        //判断是否为空
        if(preOrder.length==0){
            return null;
        }
        //找到根的值
        char rootValue = preOrder[0];
        Node root = new Node(rootValue);
        //在中序找到root的下标
        int leftSize=find(inOrder,rootValue);
        //递归找到左子树的左右子树
        char[] leftPreorder=Arrays.copyOfRange(preOrder,1,1+leftSize);
        char[] leftInOrder=Arrays.copyOfRange(inOrder,0,leftSize);
        root.left=buildTree(leftPreorder,leftInOrder);
        //递归找到右子树的左右子树
        char[] rightPreorder = Arrays.copyOfRange(preOrder, 1 + leftSize, preOrder.length);
        char[] rightInorder = Arrays.copyOfRange(inOrder, leftSize + 1, inOrder.length);
        root.right = buildTree(rightPreorder, rightInorder);
        //最后所有的树都被创建好
        return root;
    }
}
