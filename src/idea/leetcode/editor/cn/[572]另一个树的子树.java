//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看
//做它自身的一棵子树。 
//
// 示例 1: 
//给定的树 s: 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
// 
//
// 给定的树 t： 
//
// 
//   4 
//  / \
// 1   2
// 
//
// 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。 
//
// 示例 2: 
//给定的树 s： 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
// 
//
// 给定的树 t： 
//
// 
//   4
//  / \
// 1   2
// 
//
// 返回 false。 
// Related Topics 树


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    /**
     * 判断两个二叉树是否为同一二叉树
     *
     * @param s 第一个二叉树
     * @param t 第二个二叉树
     * @return true，是/false，不是
     */
    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }

        // s或t中有一个为空，并且已经判断过不同时为空，则不可能为相同二叉树
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            // 当s和t的根节点值相同，则左子树一致并且右子树一致
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        } else {
            // 根节点值不同，则不可能为相同二叉树
            return false;
        }
    }

    /**
     * 判断二叉树t是否为二叉树s的一个子树，有以下三种情况：
     * 1. s与t是相同的二叉树
     * 2. t是s.left的子树
     * 3. t是s.right的子树
     *
     * @param s 主二叉树
     * @param t 子二叉树
     * @return true，是/false，不是
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {

        // 当s主二叉树为空，则不存在子树一说
        if (s == null) {
            return false;
        }
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
