import java.util.*;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (68.99%)
 * Likes:    278
 * Dislikes: 0
 * Total Accepted:    26.4K
 * Total Submissions: 38.1K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] visited;

    public void dfs(List<Integer> list, int[] nums, int cur) {
        if (cur == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1)
                continue;
            visited[i] = 1;
            list.add(nums[i]);
            dfs(list, nums, cur + 1);
            list.remove(list.size() - 1);
            visited[i] = 0;

        }
        // list.remove(list.size() - 1);
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0)
            return res;
        visited = new int[nums.length];

        dfs(new ArrayList<>(), nums, 0);
        return res;
    }
}
