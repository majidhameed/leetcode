package com.leetcode.solutions.easy.binarytree;

import com.leetcode.solutions.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 <a href="https://leetcode.com/problems/binary-tree-postorder-traversal">145. Binary Tree Postorder Traversal</a>
<br/>
 Given the root of a binary tree, return the postorder traversal of its nodes' values.
 <pre>
 Constraints:

 The number of the nodes in the tree is in the range [0, 100].
 -100 <= Node.val <= 100
 </pre>
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        //L R V
        final List<Integer> list = new LinkedList<>();

        if (root == null) {
            return list;
        }

        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);

        return list;

    }

    @Test
    public void testExample0() {
        assertEquals(List.of(), postorderTraversal(null));
    }

    @Test
    public void testExample1() {
        assertEquals(List.of(1), postorderTraversal(new TreeNode(1)));
    }

    @Test
    public void testExample2() {
        TreeNode root = new TreeNode(1);
        root.insert(2);
        root.insert(3);
        root.insert(4);
        root.insert(5);

        assertEquals(List.of(5,4,3,2,1),postorderTraversal(root));
    }

    @Test
    public void testExample3() {
        TreeNode root = new TreeNode(5);
        root.insert(4);
        root.insert(3);
        root.insert(2);
        root.insert(1);
        assertEquals(List.of(1,2,3,4,5), postorderTraversal(root));
    }

    @Test
    public void testExampleRandom() {
        TreeNode root = new TreeNode(15);
        root.insert(41);
        root.insert(13);
        root.insert(22);
        root.insert(11);
        assertEquals(List.of(11, 13, 22, 41, 15), postorderTraversal(root));
    }
}
