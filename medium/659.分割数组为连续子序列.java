/*
 * @lc app=leetcode.cn id=659 lang=java
 *
 * [659] 分割数组为连续子序列
 *
 * https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/description/
 *
 * algorithms
 * Medium (38.94%)
 * Likes:    19
 * Dislikes: 0
 * Total Accepted:    725
 * Total Submissions: 1.9K
 * Testcase Example:  '[1,2,3,3,4,5]'
 *
 * 输入一个按升序排序的整数数组（可能包含重复数字），你需要将它们分割成几个子序列，其中每个子序列至少包含三个连续整数。返回你是否能做出这样的分割？
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 : 
 * 1, 2, 3
 * 3, 4, 5
 * 
 * 
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 : 
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * 
 * 
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 输入的数组长度范围为 [1, 10000]
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean isPossible(int[] nums) {
        if (nums.length <= 2)
            return false;
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.get(list.size() - 1).add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            List<Integer> last = list.get(list.size() - 1);
            if (nums[i] == last.get(last.size() - 1) + 1) {
                last.add(nums[i]);
            } else {
                boolean newList = true;
                for (int j = list.size() - 1; j >= 0; j--) {
                    List<Integer> temp = list.get(j);
                    if (temp.get(temp.size() - 1) + 1 == nums[i]) {
                        newList = false;
                        temp.add(nums[i]);
                        break;
                    }
                }
                if (newList) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    list.add(temp);
                }
            }
        }
        boolean ok = true;
        for (List<Integer> l : list) {
            if (l.size() < 3)
                ok = false;
        }
        return ok;
    }
}
