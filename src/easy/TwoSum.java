package easy;

/**
 * @Description 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * @Author lzj
 * @Date 2019/4/15 18:20
 */

public class TwoSum {
    static class Solution {
        int[] twoSum(int[] nums, int target) {
            int[] indices = new int[2];
            boolean is_ok = false;
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        indices[0] = i;
                        indices[1] = j;
                        is_ok = true;
                        break;
                    }
                }
                if (is_ok)
                    break;
            }
            return indices;
        }
    }
    public static void main(String[] args) {
        System.out.println("First Test: ");
        int[] test = {2, 11, 7, 15};
        Solution solution = new Solution();
        int[] result = solution.twoSum(test, 9);
        System.out.println("[" + result[0] + "," + result[1] + "]");

        System.out.println("Second Test: ");
        test = new int[]{2, 11, 7, 15};
        solution = new Solution();
        result = solution.twoSum(test, 13);
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }
}
