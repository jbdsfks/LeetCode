import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 *
 * https://leetcode-cn.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (55.33%)
 * Likes:    107
 * Dislikes: 0
 * Total Accepted:    13.8K
 * Total Submissions: 24.9K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    HashSet<List<Integer>> set = new HashSet<>();
    List<Integer> temp = new ArrayList<>();

    public void backtrack(int[] candidates, int start, int target) {
        if (target == 0) {
            // set.add(Arrays.asList(temp.toArray(new Integer[temp.size()])));
            set.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target >= candidates[i]) {
                temp.add(candidates[i]);
                backtrack(candidates, i+1, target - candidates[i]);
            } else {
                if (temp.size() > 0)
                    temp.remove(temp.size() - 1);
                return;
            }
        }
        if (temp.size() > 0)
            temp.remove(temp.size() - 1);

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates.length == 0 || (candidates.length > 0 && target < candidates[0]))
            return res;
        backtrack(candidates, 0, target);
        res.addAll(set);
        return res;
    }
}

