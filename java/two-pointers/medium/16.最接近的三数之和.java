
/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 *
 * https://leetcode-cn.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (40.59%)
 * Likes:    185
 * Dislikes: 0
 * Total Accepted:    26.2K
 * Total Submissions: 64.6K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
 * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */
import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    int temp = nums[i] + nums[j] + nums[k];
                    if (temp - target == 0) {
                        return temp;
                    } else if (temp - target > 0) {
                        while (j < k && nums[k] == nums[k - 1])
                            k--;
                        k--;
                    } else {
                        while (j < k && nums[j] == nums[j + 1])
                            j++;
                        j++;
                    }
                    int dis = Math.abs(temp - target);
                    int dis2 = Math.abs(res - target);
                    res = dis < dis2 ? temp : res;
                }
            }
        }
        return res;
    }
}
