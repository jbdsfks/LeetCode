import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 *
 * https://leetcode-cn.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (46.57%)
 * Likes:    348
 * Dislikes: 0
 * Total Accepted:    33.9K
 * Total Submissions: 72.7K
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 * 
 * 
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 说明:
 * 
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public String printTreePre(TreeNode p) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (p != null) {
                stringBuilder.append(p.val);
                stack.add(p);
                p = p.left;
            }
            stringBuilder.append("%");
            if (stack.size() == 0)
                break;
            p = stack.pop();
            
            p = p.right;
        }

        return stringBuilder.toString();
    }

    public String printTreeLast(TreeNode p) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (p != null) {
                stringBuilder.append(p.val);
                stack.add(p);
                p = p.right;
            }
            stringBuilder.append("%");
            if (stack.size() == 0)
                break;
            p = stack.pop();
            p = p.left;
        }

        return stringBuilder.toString();
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        String p1 = printTreePre(p);
        String p2 = printTreeLast(q);
        return p1.equals(p2);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSameTree(root.left, root.right);
    }
}
