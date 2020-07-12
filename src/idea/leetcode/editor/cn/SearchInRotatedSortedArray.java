package idea.leetcode.editor.cn;

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找 
// 👍 822 👎 0


public class SearchInRotatedSortedArray {
    Solution solution = new Solution();

    public void test() {
        int[] nums = {4, 5, 6, 7, 8, 1, 2, 3};
        int target = 8;
        System.out.println(solution.search(nums, target));
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray mainClass = new SearchInRotatedSortedArray();
        mainClass.test();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int medium;
            while (left <= right) {
                medium = (left + right) / 2;
                if (nums[medium] == target) {
                    return medium;
                }
                if (nums[left] <= nums[medium]) {
                    if (nums[left] <= target && target < nums[medium]) {
                        right = medium - 1;
                    } else {
                        left = medium + 1;
                    }
                } else {
                    if (nums[medium] < target && target <= nums[right]) {
                        left = medium + 1;
                    } else {
                        right = medium - 1;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}