import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (52.19%)
 * Likes:    105
 * Dislikes: 0
 * Total Accepted:    13K
 * Total Submissions: 24.8K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2]
 * 输出:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
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
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0)
                continue;
            visited[i] = 1;
            list.add(nums[i]);
            dfs(list, nums, cur + 1);
            list.remove(list.size() - 1);
            visited[i] = 0;

        }
        // list.remove(list.size() - 1);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0)
            return res;
        Arrays.sort(nums);
        visited = new int[nums.length];
        dfs(new ArrayList<>(), nums, 0);
        return res;
    }
}
