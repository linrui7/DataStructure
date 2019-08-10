package com.github7.Tree;
/*
   Author:linrui
   Date:2019/8/10
   Content:
*/

public class BinaryTreeMain {
    class Node {
        int value;
        Node right;
        Node left;

        Node(int value) {
            this.value = value;
        }
    }

    //检查一棵树root2是否是另一颗数roo1的子树
    public boolean isSubTree(Node root1, Node root2) {
        if (root1 == null)
            return false;
        return isSameTree(root1, root2) || isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
    }

    //判断两棵树是否相同。
    public static boolean isSameTree(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.value != root2.value) {
            return false;
        }
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }

    //二叉树的高度。
    public static int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            int left = height(root.left);
            int right = height(root.right);
            return (left > right ? left : right) + 1;
        }
    }

    //判断二叉树是否是平衡二叉树
    //1.左子树是平衡的
    //2.右子树是平衡的
    //3.左右高度差不大于1
    public boolean isBalanceTree(Node root) {
        if (root == null) {
            return true;
        } else {
            //分别求左右子树的高度差,并且他们左右子树的高度差也不能超过一
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanceTree(root.right) && isBalanceTree(root.left);
        }
    }

    //镜像二叉树
    public boolean isMirrorTree(Node root) {
        if (root == null) {
            return true;
        }
        return ismirror(root.left, root.right);
    }

    public boolean ismirror(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.value != root2.value) {
            return false;
        }
        return ismirror(root1.left, root1.right) && ismirror(root2.left, root2.right);
    }
}
