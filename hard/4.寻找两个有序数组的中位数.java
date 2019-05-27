/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (34.91%)
 * Likes:    1078
 * Dislikes: 0
 * Total Accepted:    56.4K
 * Total Submissions: 161.7K
 * Testcase Example:  '[1,3]\n[2]'
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 示例 1:
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * 则中位数是 2.0
 * 
 * 
 * 示例 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * 则中位数是 (2 + 3)/2 = 2.5
 * 
 * 
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0) {
            return n % 2 == 0 ? (nums2[n / 2 - 1] + nums2[n / 2]) * 1.0 / 2 : nums2[(n + 1) / 2 - 1] * 1.0;
        }
        if (n == 0) {
            return m % 2 == 0 ? (nums1[m / 2 - 1] + nums1[m / 2]) * 1.0 / 2 : nums1[(m + 1) / 2 - 1] * 1.0;
        }
        int final_size;
        boolean is_single = true;
        if ((m + n) % 2 == 0) {
            final_size = (m + n) / 2 + 1;
            is_single = false;
        } else {
            final_size = (m + n + 1) / 2;
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int[] temp = new int[final_size];
        while (k < final_size) {
            if (i < m && j < n)
                temp[k++] = nums1[i] > nums2[j] ? nums2[j++] : nums1[i++];
            else if (i == m) {
                temp[k++] = nums2[j++];
            } else if (j == n) {
                temp[k++] = nums1[i++];
            }
        }
        if (is_single) {
            return temp[final_size - 1] * 1.0;
        } else {
            return (temp[final_size - 1] + temp[final_size - 2]) * 1.0 / 2;
        }
    }
}
