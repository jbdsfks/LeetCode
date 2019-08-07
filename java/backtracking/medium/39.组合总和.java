import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 *
 * https://leetcode-cn.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (64.76%)
 * Likes:    276
 * Dislikes: 0
 * Total Accepted:    19.9K
 * Total Submissions: 30.7K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的数字可以无限制重复被选取。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public void backtrack(int[] candidates, int start, int target) {
        if (target == 0) {
            res.add(Arrays.asList(temp.toArray(new Integer[temp.size()])));
            temp.remove(temp.size() - 1);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target >= candidates[i]) {
                temp.add(candidates[i]);
                backtrack(candidates, i, target - candidates[i]);
            } else {
                if (temp.size() > 0)
                    temp.remove(temp.size() - 1);
                return;
            }
        }
        if (temp.size() > 0)
            temp.remove(temp.size() - 1);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates.length == 0 || (candidates.length > 0 && target < candidates[0]))
            return res;
        backtrack(candidates, 0, target);
        return res;
    }
}
