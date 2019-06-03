import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (60.45%)
 * Likes:    100
 * Dislikes: 0
 * Total Accepted:    16.4K
 * Total Submissions: 27.1K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其自底向上的层次遍历为：
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    // class TreeNodeOfDepth {
    //     int depth;
    //     TreeNode node;

    //     TreeNodeOfDepth(TreeNode treeNode, int depth) {
    //         this.node = treeNode;
    //         this.depth = depth;
    //     }
    // }

    // public List<List<Integer>> levelOrderBottom(TreeNode root) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     if (root == null) {
    //         return res;
    //     }
    //     Queue<TreeNodeOfDepth> queue = new LinkedList<>();
    //     int depth = 1;
    //     queue.offer(new TreeNodeOfDepth(root, depth));
    //     while (true) {
    //         List<Integer> depthNode = new ArrayList<>();
    //         while (!queue.isEmpty() && queue.peek().depth == depth) {
    //             TreeNodeOfDepth tempNode = queue.poll();
    //             depthNode.add(tempNode.node.val);
    //             if (tempNode.node.left != null)
    //                 queue.offer(new TreeNodeOfDepth(tempNode.node.left, depth + 1));
    //             if (tempNode.node.right != null)
    //                 queue.offer(new TreeNodeOfDepth(tempNode.node.right, depth + 1));
    //         }
    //         depth++;
    //         if(depthNode.size() > 0)
    //             res.add(0, depthNode);
    //         if(queue.isEmpty())
    //             break;
    //     }
    //     return res;
    // }
    List<List<Integer>> res = new ArrayList<>();
    private void levelOrder(TreeNode root, int depth){
        if(root == null)
            return;
        if(res.size()-1 < depth)
            res.add(0, new ArrayList<>());
        res.get(res.size()-1-depth).add(root.val);
        if(root.left != null)
            levelOrder(root.left, depth + 1);   
        if(root.right != null)
        levelOrder(root.right, depth + 1);
    } 
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        levelOrder(root, 0);
        return res;
    }
}
