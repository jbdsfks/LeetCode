package medium;

/**
 * @Description
 * 11. Container With Most Water
 * Given n non-negative integers a1, a2, ..., an ,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * Example:
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * 示例:
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * @Author lzj
 * @Date 2019/4/27 14:55
 */
public class ContainerWithMostWater {
    static class Solution {
        public int maxArea(int[] height) {
            int max = 0;
            for (int i=0;i < height.length;i++){
                for (int j = i;j<height.length;j++){
                    max = Integer.max(max, (j-i) * Integer.min(height[i], height[j]));
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        int[] test;
        int res_int;
        Solution solution = new Solution();

        test  = new int[]{1, 2, 3, 4, 5};
        System.out.println("res_int = " + solution.maxArea(test));
    }
}
