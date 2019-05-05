package medium;

import java.util.TreeSet;

/**
 * @Description 220. Contains Duplicate III
 * Given an array of integers, find out whether there are two distinct indices i and j in the array
 * such that the absolute difference between nums[i] and nums[j] is at most t
 * and the absolute difference between i and j is at most k.
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
 * 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * Example 3:
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 * @Author lzj
 * @Date 2019/4/29 11:28
 */
public class ContainsDuplicateIII {
    static class Solution {
        /**
         * 两层循环超时
         * 使用TreeSet构造一个滑动窗口，用来减少一次内部循环。
         * @param nums
         * @param k
         * @param t
         * @return
         */
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < nums.length; i++) {
                Integer temp = set.ceiling(nums[i]); //取大于等于
                if ((temp != null) && (long) temp - (long) nums[i] <= t) {
                    return true;
                }
                temp = set.floor(nums[i]); //取小于等于
                if ((temp != null) && (long) nums[i] - (long) temp <= t) {
                    return true;
                }
                set.add(nums[i]);  //添加
                if (set.size() > k)
                    // 如果滑动窗口大于k，去掉最左边的
                    set.remove(nums[i-k]);
            }
            return false;
        }
    }

    private static void printIntArray(int[] nums) {
        System.out.print("[ ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1)
                System.out.print(", ");
        }
        System.out.print("] ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test;
        int k, t;
        boolean res;
        Solution solution = new Solution();

        test = new int[]{1, 2, 3, 1};
        k = 3;
        t = 0;
        res = solution.containsNearbyAlmostDuplicate(test, k, t);
        System.out.println("test array");
        printIntArray(test);
        System.out.println("k = " + k + "\t t = " + t + "\n res = " + res + "\t ac = true");

        test = new int[]{-1, Integer.MAX_VALUE};
        k = 1;
        t = Integer.MAX_VALUE;
        res = solution.containsNearbyAlmostDuplicate(test, k, t);
        System.out.println("test array");
        printIntArray(test);
        System.out.println("k = " + k + "\t t = " + t + "\n res = " + res + "\t ac = false");

        test = new int[]{1,5,9,1,5,9};
        k = 2;
        t = 3;
        res = solution.containsNearbyAlmostDuplicate(test, k, t);
        System.out.println("test array");
        printIntArray(test);
        System.out.println("k = " + k + "\t t = " + t + "\n res = " + res + "\t ac = false");

        test = new int[]{2,1};
        k = 1;
        t = 1;
        res = solution.containsNearbyAlmostDuplicate(test, k, t);
        System.out.println("test array");
        printIntArray(test);
        System.out.println("k = " + k + "\t t = " + t + "\n res = " + res + "\t ac = true");
    }
}
