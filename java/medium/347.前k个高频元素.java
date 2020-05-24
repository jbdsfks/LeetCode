/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前K个高频元素
 *
 * https://leetcode-cn.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (56.49%)
 * Likes:    121
 * Dislikes: 0
 * Total Accepted:    12K
 * Total Submissions: 21.3K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 
 * 示例 1:
 * 
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 
 * 说明：
 * 
 * 
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 
 * 
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        ArrayList[] bucket = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                ArrayList<Integer> list = new ArrayList<>();
                bucket[entry.getValue()] = list;
            }
            bucket[entry.getValue()].add(entry.getKey());
        }
        for (int i = bucket.length - 1; i > 0 && res.size() < k; i--) {
            if (bucket[i] != null)
                res.addAll(bucket[i]);
        }
        while (res.size() > k)
            res.remove(res.size() - 1);
        return res;
    }
}
