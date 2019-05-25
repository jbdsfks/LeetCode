package easy;

/**
 * @Description 53. Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * @Author lzj
 * @Date 2019/5/25 20:06
 */
public class MaximumSubarray {
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length == 0)
                return 0;
            // max默认值
            int max = nums[0];
            // 子序列和
            int tempSum = max;
            for (int i = 1;i < nums.length; i++){
                // 如果子序列和 < 0 ，重置子序列和
                if (tempSum < 0)
                    tempSum = nums[i];
                else
                    tempSum += nums[i];  // 如果子序列和为正， 扩展子序列
                max = Math.max(tempSum, max);  // max 为 当前max与子序列和的最大值
            }
            return max;
        }
    }
}
