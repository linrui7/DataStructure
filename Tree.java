package com.github7.复习0823;
/*
   Author:linrui
   Date:2019/8/23
   Content:
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    List<Integer> list = new LinkedList<>();

    void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    List<Integer> preOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        List<Integer> left = preOrder1(root.left);
        List<Integer> right = preOrder1(root.right);
        list.addAll(left);
        list.addAll(right);
        return list;
    }

    int TreeNodeCount(TreeNode root) {
        if (root == null) return 0;
        return TreeNodeCount(root.left) + TreeNodeCount(root.right) + 1;
    }

    int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return left > right ? left + 1 : right + 1;
    }

    //求第k层节点个数
    int kheight(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return kheight(root.left, k - 1) + kheight(root.right, k - 1);
    }

    //层序遍历  队列  放入根打印 出队列  然后放入左右孩子，然后继续出队首。
    void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //出队首 打印  加入左右不为空子树
            TreeNode head = queue.poll();
            System.out.println(head.val);
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
        }
    }

    /*

                A
              B   C
            D    E  F
         pre:  A  BD  CEF
          in:  DB  A  ECF
        post:  DB  EFC  A

    */

    //中序和后序遍历创建二叉树
    TreeNode bulid2(List<Integer> in, List<Integer> post) {

        if (in.size() == 0) {
            return null;
        }
        //从后首先找到根
        int rootValue = post.get(post.size() - 1);
        //从中找到根的下标，找到左右
        int leftCount = in.indexOf(rootValue);

        List<Integer> leftIn = in.subList(0, leftCount);
        List<Integer> leftPost = post.subList(0, leftCount);
        List<Integer> rightIn = in.subList(1 + leftCount, in.size());
        List<Integer> rightPost = post.subList(leftCount, post.size() - 1);

        TreeNode root = new TreeNode(rootValue);
        root.left = bulid2(leftIn, leftPost);
        root.right = bulid2(rightIn, rightPost);
        return root;
    }

    TreeNode bulid1(List<Integer> pre, List<Integer> in) {
        if (pre.size() == 0) {
            return null;
        }
        int rootValue = pre.get(0);
        int leftCount = in.indexOf(rootValue);
        int rightCount = pre.size() - 1 - leftCount;
        List<Integer> leftPre = pre.subList(1, 1 + leftCount);
        List<Integer> leftIn = in.subList(0, leftCount);
        List<Integer> rightPre = pre.subList(1 + leftCount, pre.size());
        List<Integer> rightIn = in.subList(leftCount + 1, in.size());
        TreeNode root = new TreeNode(rootValue);
        root.left = bulid1(leftPre, leftIn);
        root.right = bulid1(rightPre, rightIn);
        return root;
    }


}
