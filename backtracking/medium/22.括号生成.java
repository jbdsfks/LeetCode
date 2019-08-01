/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (70.26%)
 * Likes:    388
 * Dislikes: 0
 * Total Accepted:    24.5K
 * Total Submissions: 34.8K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 * 
 */
class Solution {
    List<String> res = new ArrayList<>();

    public void backtrack(String s, int leftNum, int rightNum){
        if(leftNum == 0 && rightNum == 0){
            res.add(s);
            return;
        }
        if(leftNum < 0 || rightNum < 0 || leftNum > rightNum)
            return;
        
        backtrack(s+"(", leftNum-1, rightNum);
        backtrack(s+")", leftNum, rightNum-1);
    }
    public List<String> generateParenthesis(int n) {
        if(n == 0)
            return res;
        backtrack("", n, n);
        return res;
    }
}

