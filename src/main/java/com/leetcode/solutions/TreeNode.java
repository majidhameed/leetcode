package com.leetcode.solutions;

public class TreeNode {

     public int val;

     public TreeNode left;
     public TreeNode right;

     public TreeNode() {
     }

     public TreeNode(int val) { this.val = val;
     }

     public TreeNode (int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }


     public void insert(int val) {
         if (this.val > val) {
             if (left == null) {
                 left = new TreeNode(val);
             } else {
                 left.insert(val);
             }
          } else  {
             if (right == null) {
                 right = new TreeNode(val);
             } else {
                 right.insert(val);
             }
         }
     }

 }
