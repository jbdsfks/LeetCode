/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (38.60%)
 * Likes:    125
 * Dislikes: 0
 * Total Accepted:    18.9K
 * Total Submissions: 48.9K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最小深度。
 * 
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回它的最小深度  2.
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int minDepth(TreeNode root) {
        // 空节点，深度为0
        if (root == null)
            return 0;
        // 递归获取左子树最小深度
        int leftMin = minDepth(root.left);
        // 递归获取右子树最小深度
        int rightMin = minDepth(root.right);
        // 左右子树均不为空，返回左右子树最小深度+1
        if (root.left != null && root.right != null)
            return Math.min(leftMin, rightMin) + 1;
        // 左子树均为空，返回右子树最小深度+1
        if (root.left == null)
            return rightMin + 1;
        // 右子树均为空，返回左子树最小深度+1
        if (root.right == null)
            return leftMin + 1;
        // 左右子树均为空, 深度为1
        return 1;
    }
}
