package com.github7.Tree;
/*
   Author:linrui
   Date:2019/8/24
   Content:
*/

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CreateTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }


    //层序遍历
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
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


    //前序和中序创建二叉树
    TreeNode bulid1(List<Integer> pre, List<Integer> in) {
        if (pre.size() == 0) {
            return null;
        }
        int rootValue = pre.get(0);
        int leftCount = in.indexOf(rootValue);
        int rightCount = in.size() - leftCount - 1;
        //         pre:  A  BD  CEF
        //          in:  DB  A  ECF
        List<Integer> leftPre = pre.subList(1, leftCount + 1);
        List<Integer> leftIn = in.subList(0, leftCount);
        List<Integer> rightpre = pre.subList(1 + leftCount, pre.size());
        List<Integer> rightIn = in.subList(1 + leftCount, in.size());
        TreeNode root = new TreeNode(rootValue);
        root.left = bulid1(leftPre, leftIn);
        root.right = bulid1(rightpre, rightIn);
        return root;
    }


    //中序和后序创建二叉树
    //  in:  DB  A  ECF
    //post:  DB  EFC  A
    TreeNode bulid2(List<Integer> in, List<Integer> post) {
        if (in.size() == 0) {
            return null;
        }

        int rootValue = post.get(post.size() - 1);
        int leftCount = in.indexOf(rootValue);

        List<Integer> leftIn = in.subList(0, leftCount);
        List<Integer> leftPost = post.subList(0, leftCount);
        List<Integer> rightIn = in.subList(leftCount + 1, in.size());
        List<Integer> rightPost = post.subList(leftCount, post.size() - 1);

        TreeNode root = new TreeNode(rootValue);
        root.left = bulid2(leftIn, leftPost);
        root.right = bulid2(rightIn, rightPost);
        return root;
    }
}
