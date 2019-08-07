import java.util.*;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (22.42%)
 * Likes:    1002
 * Dislikes: 0
 * Total Accepted:    56.7K
 * Total Submissions: 253.1K
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-2 && nums[i] <= 0; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int j = i+1;
                int k = nums.length - 1;
                int sum = 0 - nums[i];
                while(j < k){
                    if(nums[j] + nums[k] == sum){
                        res.add(Arrays.asList(nums[i], nums[j],nums[k]));
                        while(j < k && nums[j] == nums[j+1]) j++;
                        while(j < k && nums[k] == nums[k-1]) k--;
                        j++;
                        k--;
                    }else if(nums[j] + nums[k] > sum){
                        while(j < k && nums[k] == nums[k-1]) k--;
                        k--;
                    }else{
                        while(j < k && nums[j] == nums[j+1]) j++;
                        j++;
                    }
                }
            }
        }
        return res;
    }
}
