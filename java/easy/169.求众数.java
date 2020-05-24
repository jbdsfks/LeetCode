/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 求众数
 *
 * https://leetcode-cn.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (59.17%)
 * Likes:    244
 * Dislikes: 0
 * Total Accepted:    43.5K
 * Total Submissions: 73.5K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 
 * 示例 1:
 * 
 * 输入: [3,2,3]
 * 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 
 * 
 */
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            hashmap.merge(nums[i], 1, (X, Y) -> (X + 1));
        }
        int res = 0;
        int value = -1;
        for (Integer key : hashmap.keySet()) {
            // System.out.println(hashmap.get(key));
            if (hashmap.get(key) > value) {
                res = key;
                value = hashmap.get(key);
            }
        }
        return res;
    }
}
