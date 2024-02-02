package org.orders.let.task_02;

/**
 * You are given the root of a binary tree that consists of exactly 3 nodes: the root, its left child, and its right child.
 * <p>
 * Return true if the value of the root is equal to the sum of the values of its two children, or false otherwise.
 * <p>
 * Input: root = [10,4,6]
 * Output: true
 * Explanation: The values of the root, its left child, and its right child are 10, 4, and 6, respectively.
 * 10 is equal to 4 + 6, so we return true.
 * <p>
 * Input: root = [5,3,1]
 * Output: false
 * Explanation: The values of the root, its left child, and its right child are 5, 3, and 1, respectively.
 * 5 is not equal to 3 + 1, so we return false.
 */
public class Solution {
    public boolean checkTree(TreeNode root) {
        return root.left.val + root.right.val == root.val;

        //        if (root.left.val + root.right.val == root.val) {
        //            return true;
        //        } else {
        //            return false;
        //        }
    }
}
