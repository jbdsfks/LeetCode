package easy;

import java.util.Stack;

/**
 * @Description 496. Next Greater Element I
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second array is 3.
 * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * For number 2 in the first array, the next greater number for it in the second array is 3.
 * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * 示例 1:
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 示例 2:
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 * 对于num1中的数字2，第二个数组中的下一个较大数字是3。
 * 对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 注意:
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2 的数组大小都不超过1000。
 * @Author lzj
 * @Date 2019/5/7 20:37
 */
public class NextGreaterElementI {
    static class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] res = new int[nums1.length];
            for(int i = 0;i<nums1.length;i++){
                Stack<Integer> stack = new Stack<>();
                int j;
                j = nums2.length-1;
                while (j >= 0 && nums2[j] != nums1[i]) {
                    stack.push(nums2[j--]);
                }
                while (!stack.empty() && stack.peek() < nums1[i])
                    stack.pop();
                res[i] = stack.empty() ? -1:stack.pop();
            }
            return res;
        }
    }

    public static void printArr(int[] nums){
        for (int i=0;i<nums.length;i++){
            System.out.print(nums[i]+", ");
        }

    }
    public static void main(String[] args) {
        int[][] nums1 = new int[][]{
                {4, 1, 2},
                {2, 4},
        };
        int[][] nums2 = new int[][]{
                {1, 3, 4, 2},
                {1, 2, 3, 4},
        };
        int[][] acs = new int[][]{
                {-1,3,-1},
                {3,-1}
        };

        Solution solution = new Solution();
        for (int i = 0; i < nums1.length;i++){
            System.out.print(" nums1 : ");
            printArr(nums1[i]);
            System.out.print("\t nums2 : ");
            printArr(nums2[i]);
            System.out.print("\t ac: ");
            printArr(acs[i]);
            int[] res = solution.nextGreaterElement(nums1[i], nums2[i]);
            System.out.print("\t res = ");
            printArr(res);
            System.out.println();
        }
    }
}
