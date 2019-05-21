package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 659. Split Array into Consecutive Subsequences
 * You are given an integer array sorted in ascending order (may contain duplicates),
 * you need to split them into several subsequences, where each subsequences consist of at least 3 consecutive integers.
 * Return whether you can make such a split.
 * Example 1:
 * Input: [1,2,3,3,4,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences :
 * 1, 2, 3
 * 3, 4, 5
 * Example 2:
 * Input: [1,2,3,3,4,4,5,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * Example 3:
 * Input: [1,2,3,4,4,5]
 * Output: False
 * Note:
 * The length of the input is in range of [1, 10000]
 * 输入一个按升序排序的整数数组（可能包含重复数字），你需要将它们分割成几个子序列，其中每个子序列至少包含三个连续整数。
 * 返回你是否能做出这样的分割？
 * 示例 1：
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 * 示例 2：
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * 示例 3：
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 * @Author lzj
 * @Date 2019/5/21 20:27
 */
public class SplitArrayIntoConsecutiveSubsequences {
    static class Solution {
        /**
         * 执行用时 : 589 ms, 在Split Array into Consecutive Subsequences的Java提交中击败了5.71% 的用户
         * 内存消耗 : 64.1 MB, 在Split Array into Consecutive Subsequences的Java提交中击败了50.00% 的用户
         * 可以优化
         * 当前思路，构造出分裂List，
         * 对于每个整数，如果List的最后一个子序列不符合放置顺序，那么就向前面的子序列查找，如果所有子序列都不符合，
         * 新建一个子序列
         * 最后统计所有子序列长度，
         * 如果都大于3，说明符合，否则false，属于全分裂方法。
         * @param nums
         * @return
         */
        public boolean isPossible(int[] nums) {
            if (nums.length <= 2)
                return false;
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            list.get(list.size() - 1).add(nums[0]);
            for (int i = 1; i < nums.length; i++){
                List<Integer> last = list.get(list.size()-1);
                if (nums[i] == last.get(last.size()-1) + 1) {
                    last.add(nums[i]);
                }
                else{
                    boolean newList = true;
                    for (int j = list.size() - 1; j >= 0; j--){
                        List<Integer> temp = list.get(j);
                        if (temp.get(temp.size()-1)+1 == nums[i]){
                            newList = false;
                            temp.add(nums[i]);
                            break;
                        }
                    }
                    if (newList){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        list.add(temp);
                    }
                }
            }
            boolean ok = true;
            for (List<Integer> l:list){
                if (l.size() < 3)
                    ok = false;
            }
            return ok;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3,3,3,4,4};
        Solution solution = new Solution();
        solution.isPossible(nums);
    }
}
