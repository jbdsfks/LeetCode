package medium;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @Description 347. Top K Frequent Elements
 * Given a non-empty array of integers, return the k most frequent elements.
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
// * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * @Author lzj
 * @Date 2019/5/17 15:05
 */
public class TopKFrequentElements {
    static class Solution {
        /**
         * 思路： map 所有的 nums 得到各数出现频次
         * bucket 存放每个 index 次的所有数 List<Integer>
         *     最后从后往前找出 bucket 中的 k 个数
         * @param nums
         * @param k
         * @return
         */
        public List<Integer> topKFrequent(int[] nums, int k) {
            List<Integer> res = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int n : nums)
                map.put(n, map.getOrDefault(n, 0)+1);
            List[] bucket = new ArrayList[nums.length+1];
            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                if (bucket[entry.getValue()] == null){
                    ArrayList<Integer> list = new ArrayList<>();
                    bucket[entry.getValue()] = list;
                }
                bucket[entry.getValue()].add(entry.getKey());
            }
            for (int i = bucket.length - 1;i > 0 && res.size() < k ; i--){
                if (bucket[i] != null)
                    res.addAll(bucket[i]);
            }
            while (res.size() > k)
                res.remove(res.size()-1);
            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        int k = 2;
        Solution solution = new Solution();
        List<Integer> res = solution.topKFrequent(nums, k);
        for (Integer i : res){
            System.out.print(i + ", ");
        }
    }
}
