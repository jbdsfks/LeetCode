package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @Description 373. Find K Pairs with Smallest Sums
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * Example 1:
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [1,1],[1,1]
 * Explanation: The first 2 pairs are returned from the sequence:
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * Example 3:
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [1,3],[2,3]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 * 示例 1:
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 示例 3:
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 * @Author lzj
 * @Date 2019/5/19 16:28
 */
public class FindKPairsWithSmallestSums {
    static class Solution {
        //        /**
//         * 笨方法，匹配所有的组合，然后导出前K个，
//         * 执行用时 : 404 ms, 在Find K Pairs with Smallest Sums的Java提交中击败了5.23% 的用户
//         * 内存消耗 : 111.8 MB, 在Find K Pairs with Smallest Sums的Java提交中击败了5.34% 的用户
//         * @param nums1
//         * @param nums2
//         * @param k
//         * @return
//         */
//        public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//            TreeMap<Integer, List<int[]>> uvs = new TreeMap<>();
//            for (int item : nums1) {
//                for (int value : nums2) {
//                    List<int[]> uv = uvs.getOrDefault(item + value, new ArrayList<>());
//                    uv.add(new int[]{item, value});
//                    uvs.put(item + value, uv);
//                }
//            }
//            List<int[]> resultList = new ArrayList<>();
//
//            while (resultList.size() < k && uvs.size() > 0){
//                List<int[]> uv = uvs.pollFirstEntry().getValue();
//                resultList.addAll(uv);
//            }
//            while (resultList.size() > k){
//                resultList.remove(resultList.size()-1);
//            }
//            return resultList;
//        }

        /**
         * 堆排序实现
         * @param nums1
         * @param nums2
         * @param k
         * @return
         */
        public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<int[]> resultList = new ArrayList<>();
            // 各种null 或 k == 0
            if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k == 0)
                return resultList;
            // 构造小顶堆
            PriorityQueue<Tuple> heap = new PriorityQueue<>();
            // 先将nums1的第1个和nums2中所有的组合压入堆
            for (int j = 0; j < nums2.length; j++) {
                heap.offer(new Tuple(0, j, nums1[0] + nums2[j]));
            }
            // 大于等于k个或总组合个数退出
            for (int i = 0; i < Math.min(k, nums1.length * nums2.length); i++) {
                // 取堆顶
                Tuple tuple = heap.poll();
                // 对顶加入结果集，这里，如果是第一次，那么必定是index(0,0)，肯定最小
                resultList.add(new int[]{nums1[tuple.x], nums2[tuple.y]});
                // 如果当前元素的nums1的index == nums1.length-1，则继续
                if (tuple.x == nums1.length - 1) {
                    continue;
                }
                // 不然构造Tuple(tuple.x + 1, tuple.y, nums1[tuple.x + 1] + nums2[tuple.y])，压入堆中
                heap.offer(new Tuple(tuple.x + 1, tuple.y, nums1[tuple.x + 1] + nums2[tuple.y]));
            }
            return resultList;
        }

        class Tuple implements Comparable<Tuple> {
            int x;
            int y;
            int val;

            /**
             * 堆的对象
             * @param x nums1的下标
             * @param y nums2的下标
             * @param val 和值
             */
            Tuple(int x, int y, int val) {
                this.x = x;
                this.y = y;
                this.val = val;
            }

            /**
             * 重写的堆排序方法
             * @param o 对比对象
             * @return this.val - o.val 保持小顶堆
             */
            @Override
            public int compareTo(Tuple o) {
                return this.val - o.val;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {1, 2, 3};
        int k = 10;
        Solution solution = new Solution();
        solution.kSmallestPairs(nums1, nums2, k);
    }
}
