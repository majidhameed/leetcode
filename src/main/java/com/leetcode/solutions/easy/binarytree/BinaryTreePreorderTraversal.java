package com.leetcode.solutions.easy.binarytree;

import com.leetcode.solutions.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">144. Binary Tree Preorder Traversal</a>
 <br/>
 Given the root of a binary tree, return the preorder traversal of its nodes' values.

 <pre>
 Constraints:

 The number of nodes in the tree is in the range [0, 100].
 -100 <= Node.val <= 100


 Follow up: Recursive solution is trivial, could you do it iteratively?
 </pre>
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {

        final List<Integer> list = new LinkedList<>();

        if (root == null) {
            return list;
        }
        // VLR - Visit Left Right
        list.add(root.val);
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));

        return list;
    }

    @Test
    public void testExample0() {
        assertEquals(List.of(), preorderTraversal(null));
    }

    @Test
    public void testExample1() {
        assertEquals(List.of(1), preorderTraversal(new TreeNode(1)));
    }

    @Test
    public void testExample3() {
        TreeNode root = new TreeNode(1);
        root.insert(2);
        root.insert(3);
        root.insert(4);
        root.insert(5);

        assertEquals(List.of(1,2,3,4,5),preorderTraversal(root));
    }

    @Test
    public void testExample4() {
        TreeNode root = new TreeNode(5);
        root.insert(4);
        root.insert(3);
        root.insert(2);
        root.insert(1);
        assertEquals(List.of(5,4,3,2,1), preorderTraversal(root));
    }

    @Test
    public void testExampleRandom() {
        TreeNode root = new TreeNode(15);
        root.insert(41);
        root.insert(13);
        root.insert(22);
        root.insert(11);
        assertEquals(List.of(15, 13, 11, 41, 22), preorderTraversal(root));
    }

}
