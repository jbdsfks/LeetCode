/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (29.53%)
 * Likes:    1843
 * Dislikes: 0
 * Total Accepted:    127.3K
 * Total Submissions: 430.8K
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s.equals(""))
            return res;
        String sub_s = String.valueOf(s.charAt(0));
        int fromIndex = 0;
        for (int i = 1; i < s.length(); i++) {
            String s_temp = String.valueOf(s.charAt(i));
            if (!sub_s.contains(s_temp)) {
                sub_s += s_temp;
            } else {
                res = res > sub_s.length() ? res : sub_s.length();
                i = s.indexOf(s_temp, fromIndex) + 1;
                fromIndex = i;
                sub_s = String.valueOf(s.charAt(i));

            }
        }
        return res > sub_s.length() ? res : sub_s.length();
    }
}
