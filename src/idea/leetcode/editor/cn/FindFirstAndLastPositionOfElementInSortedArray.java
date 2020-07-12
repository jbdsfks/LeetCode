package idea.leetcode.editor.cn;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找 
// 👍 501 👎 0


public class FindFirstAndLastPositionOfElementInSortedArray {
    Solution solution = new Solution();

    public void test() {

    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray mainClass = new FindFirstAndLastPositionOfElementInSortedArray();
        mainClass.test();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int binarySearch(int[] nums, int target) {
            if (nums == null) {
                return -1;
            }
            int left = 0;
            int right = nums.length - 1;
            int medium;
            while (left <= right) {
                medium = (left + right) / 2;
                if (nums[medium] == target) {
                    return medium;
                }
                if (nums[medium] < target) {
                    left = medium + 1;
                } else {
                    right = medium - 1;
                }
            }
            return -1;
        }

        public int[] searchRange(int[] nums, int target) {
            int[] result = {-1, -1};
            int binarySearchIndex = binarySearch(nums, target);
            if (binarySearchIndex == -1) {
                return result;
            }
            for (int i = binarySearchIndex; i >= 0; i--){
                if (nums[i] == target) {
                    result[0] = i;
                }
            }
            for (int i = binarySearchIndex; i < nums.length; i++){
                if (nums[i] == target) {
                    result[1] = i;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}