import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
 *
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/description/
 *
 * algorithms
 * Medium (58.31%)
 * Likes:    171
 * Dislikes: 0
 * Total Accepted:    8.7K
 * Total Submissions: 14.8K
 * Testcase Example:  '3'
 *
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 递归解法
     * 对于每个使用i作为根节点的树
     * 左子树为[1,2,3,...,i-1]构造的二叉树
     * 右子树为[i+1,i+2,...,n]构造的二叉树
     * 最后做组合
     * √ Accepted
     * √ 9/9 cases passed (6 ms)
     * √ Your runtime beats 61.29 % of java submissions
     * √ Your memory usage beats 45.55 % of java submissions (40.2 MB)
     */
    // public LinkedList<TreeNode> generateTrees(int start, int end) {
    //     LinkedList<TreeNode> allTrees = new LinkedList<>();
    //     if(start > end){
    //         allTrees.add(null);
    //         return allTrees;
    //     }
    //     for (int i = start; i <= end; i++) {
    //         LinkedList<TreeNode> leftTrees = generateTrees(start, i - 1);
    //         LinkedList<TreeNode> rightTrees = generateTrees(i + 1, end);
    //         for (TreeNode l : leftTrees) {
    //             for (TreeNode r : rightTrees) {
    //                 TreeNode node = new TreeNode(i);
    //                 node.left = l;
    //                 node.right = r;
    //                 allTrees.add(node);
    //             }
    //         }
    //     }
    //     return allTrees;
    // }
    // public List<TreeNode> generateTrees(int n) {
    //     if(n == 0)
    //         return new LinkedList<TreeNode>();
    //     return generateTrees(1, n);
    // }

    /**
     * dp解法
     * 递归均可转化为dp
     * 优化思路，计算[1,2]，其余[2,3],...,[n-1.n]采用偏移量
     * √ Accepted
     * √ 9/9 cases passed (4 ms)
     * √ Your runtime beats 87.74 % of java submissions
     * √ Your memory usage beats 67.5 % of java submissions (38.8 MB)
     */
    public TreeNode clone(TreeNode root, int offset){
        if(root == null)
            return null;
        TreeNode node = new TreeNode(root.val + offset);
        node.left = clone(root.left, offset);
        node.right = clone(root.right, offset);
        return node;
    }
    public List<TreeNode> generateTrees(int n){
        ArrayList<TreeNode>[] dp = new ArrayList[n+1];
        dp[0] = new ArrayList<TreeNode>();
        if(n == 0){
            return dp[0];
        }
        dp[0].add(null);
        for (int i = 1; i <= n; i++) {
            dp[i] = new ArrayList<TreeNode>();
            for(int root = 1;root <= i;root++){
                int left = root-1;
                int right = i - root;
                for (TreeNode leftTree : dp[left]) {
                    for (TreeNode rightTree : dp[right]) {
                        TreeNode treeRoot = new TreeNode(root);
                        treeRoot.left = leftTree;
                        treeRoot.right = clone(rightTree, root);
                        dp[i].add(treeRoot);
                    }
                }

            }

        }
        return dp[n];
    }
}

