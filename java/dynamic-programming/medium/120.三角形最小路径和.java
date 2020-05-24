/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 *
 * https://leetcode-cn.com/problems/triangle/description/
 *
 * algorithms
 * Medium (61.12%)
 * Likes:    191
 * Dislikes: 0
 * Total Accepted:    17.6K
 * Total Submissions: 28.8K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 
 * 例如，给定三角形：
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 
 * 说明：
 * 
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * 
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] pathNumber = new int[row];
        for (int i = 0; i < row; i++) {
            pathNumber[i] = triangle.get(row-1).get(i);
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j =0; j <= i; j++) {
                int min = Math.min(pathNumber[j], pathNumber[j+1]);
                pathNumber[j] = triangle.get(i).get(j) + min;
            }
        }
        return pathNumber[0];
    }
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int row = triangle.size();
    //     int[] dp = new int[row];
    //     for (int i = 0; i < row; i++) dp[i] = triangle.get(row - 1).get(i);
    //     for (int i = row - 2; i >= 0; i--)
    //         for (int j = 0; j <= i; j++)
    //             dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
    //     return dp[0];
    // }
}
