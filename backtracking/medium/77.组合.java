import java.util.*;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (67.61%)
 * Likes:    121
 * Dislikes: 0
 * Total Accepted:    11.9K
 * Total Submissions: 17.5K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public void backtrack(int n, int k, int start) {
        if (k == 0) {
            this.res.add(new ArrayList<>(this.temp));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            this.temp.add(i);
            backtrack(n, k-1, i + 1);
            this.temp.remove(this.temp.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0)
            return res;
        backtrack(n, k, 1);
        return res;
    }
}
