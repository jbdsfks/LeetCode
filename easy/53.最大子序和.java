/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 *
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (45.07%)
 * Likes:    943
 * Dislikes: 0
 * Total Accepted:    58.3K
 * Total Submissions: 129.3K
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 * 
 * 进阶:
 * 
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        // max默认值
        int max = nums[0];
        // 子序列和
        int tempSum = max;
        for (int i = 1; i < nums.length; i++) {
            // 如果子序列和 < 0 ，重置子序列和
            if (tempSum < 0)
                tempSum = nums[i];
            else
                tempSum += nums[i]; // 如果子序列和为正， 扩展子序列
            max = Math.max(tempSum, max); // max 为 当前max与子序列和的最大值
        }
        return max;
    }
}
