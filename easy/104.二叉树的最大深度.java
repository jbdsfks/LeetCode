import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Map.Entry;

/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (69.13%)
 * Likes:    283
 * Dislikes: 0
 * Total Accepted:    48.3K
 * Total Submissions: 69.8K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最大深度。
 * 
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回它的最大深度 3 。
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 1;
        Stack<Map.Entry<TreeNode, Integer>> stack = new Stack<>();
        stack.add(new AbstractMap.SimpleEntry<TreeNode, Integer>(root, 1));
        while (!stack.isEmpty()) {
            Map.Entry<TreeNode, Integer> entry = stack.pop();
            root = entry.getKey();
            int currentDepth = entry.getValue();
            depth = Math.max(depth, currentDepth);
            if (root.left != null) {
                stack.add(new AbstractMap.SimpleEntry<>(root.left, currentDepth + 1));
            }
            if (root.right != null)
                stack.add(new AbstractMap.SimpleEntry<>(root.right, currentDepth + 1));
        }
        return depth;
        // return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
