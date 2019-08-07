/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (25.22%)
 * Likes:    892
 * Dislikes: 0
 * Total Accepted:    61.3K
 * Total Submissions: 243.1K
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */
class Solution {
    boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    String longestPalindrome(String s) {
        if (isPalindrome(s)) {
            return s;
        }
        String res = "";
        for (int i = 0; i < s.length() - 1; i++) {
            int j = s.lastIndexOf(s.charAt(i));

            while (i <= j) {
                String temp = s.substring(i, j + 1);
                if (isPalindrome(temp)) {
                    res = res.length() > temp.length() ? res : temp;
                    break;
                } else {
                    j = i + s.substring(i, j).lastIndexOf(s.charAt(i));
                }
            }
        }
        return res;
    }
}
