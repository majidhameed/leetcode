package com.leetcode.solutions.easy;

public class TreeNode {

     int val;

     TreeNode left;
     TreeNode right;

     TreeNode() {
     }

     TreeNode(int val) { this.val = val;
     }

     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }


     void insert(int val) {
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
