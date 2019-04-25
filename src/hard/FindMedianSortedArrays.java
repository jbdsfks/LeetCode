package hard;

/**
 * @Description 4. Median of Two Sorted Arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 * @Author lzj
 * @Date 2019/4/16 18:03
 */
public class FindMedianSortedArrays {
    private static class Solution {
        private double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            if(m == 0 && n == 0)
                return 0;
            if (m == 0)
                return n % 2 == 0 ? (nums2[n / 2 - 1] + nums2[n / 2]) * 1.0 / 2 : nums2[(n + 1) / 2 - 1] * 1.0;
            if (n == 0)
                return m % 2 == 0 ? (nums1[m / 2 - 1] + nums1[m / 2]) * 1.0 / 2 : nums1[(m + 1) / 2 - 1] * 1.0;
            int final_size;
            boolean is_single = true;
            if ((m + n) % 2 == 0) {
                final_size = (m + n) / 2 + 1;
                is_single = false;
            } else
                final_size = (m + n + 1) / 2;
            int i = 0, j = 0, k = 0;
            int[] temp = new int[final_size];
            while (k < final_size){
                if(i < m && j < n)
                    temp[k++] = nums1[i]>nums2[j]? nums2[j++]:nums1[i++];
                else if(i == m)
                    temp[k++] = nums2[j++];
                else if(j == n)
                    temp[k++] = nums1[i++];
            }
            if (is_single)
                return temp[final_size-1] * 1.0;
            else
                return (temp[final_size-1] + temp[final_size-2]) * 1.0 / 2;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{2, 4};
        Solution solution = new Solution();
        double res = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);

        nums1 = new int[]{1};
        nums2 = new int[]{2, 3, 4};
        res = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);

        nums1 = new int[]{2, 3, 4};
        nums2 = new int[]{1};
        res = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);

        nums1 = new int[]{1, 2, 3, 4, 5};
        nums2 = new int[]{6, 7, 8, 9, 10};
        res = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);

        nums1 = new int[]{1, 3, 5, 7, 9};
        nums2 = new int[]{2, 4, 6, 8, 10};
        res = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);

        nums1 = new int[]{3};
        nums2 = new int[]{-3, -2};
        res = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);

    }
}
