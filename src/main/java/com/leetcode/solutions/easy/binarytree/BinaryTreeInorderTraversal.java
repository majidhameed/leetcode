package com.leetcode.solutions.easy.binarytree;

import com.leetcode.solutions.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">94. Binary Tree Inorder Traversal</a>
 <br/>
 Given the root of a binary tree, return the inorder traversal of its nodes' values.
 <pre>
 Constraints:

 The number of nodes in the tree is in the range [0, 100].
 -100 <= Node.val <= 100


 Follow up: Recursive solution is trivial, could you do it iteratively?
 </pre>
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return new LinkedList<>();
        }

        final List<Integer> list = new LinkedList<>();

        // L V R
        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));

        return list;
    }

    @Test
    public void testExample0() {
       assertEquals(List.of(), inorderTraversal(null));
    }

    @Test
    public void testExample1() {
        assertEquals(List.of(1), inorderTraversal(new TreeNode(1)));
    }

    @Test
    public void testExampleSortAsc() {
        TreeNode root = new TreeNode(1);
        root.insert(2);
        root.insert(3);
        root.insert(4);
        root.insert(5);
        assertEquals(List.of(1,2,3,4,5), inorderTraversal(root));
    }

    @Test
    public void testExampleSortDesc() {
        TreeNode root = new TreeNode(5);
        root.insert(4);
        root.insert(3);
        root.insert(2);
        root.insert(1);
        assertEquals(List.of(1,2,3,4,5), inorderTraversal(root));
    }

    @Test
    public void testExampleRandom() {
        TreeNode root = new TreeNode(15);
        root.insert(41);
        root.insert(13);
        root.insert(22);
        root.insert(11);
        assertEquals(List.of(11,13,15,22,41), inorderTraversal(root));
    }

}
