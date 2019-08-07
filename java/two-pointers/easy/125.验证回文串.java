/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 *
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (40.47%)
 * Likes:    97
 * Dislikes: 0
 * Total Accepted:    45.2K
 * Total Submissions: 111.6K
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 
 * 示例 1:
 * 
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "race a car"
 * 输出: false
 * 
 * 
 */
class Solution {
    public boolean isNumber(char c){
        return c >= '0' && c <= '9';
    }
    public boolean isCase(char c){
        return c >= 'a' && c <= 'z';
    }
    public boolean isPalindrome(String s) {
        
        char[] chars = s.toLowerCase().toCharArray();
        int i = 0, j = chars.length - 1;

        while (i < j) {
            while (i < chars.length && !Character.isLetterOrDigit(chars[i]))
                i++;
            while (j >= 0 && !Character.isLetterOrDigit(chars[j]))
                j--;
            if (i < chars.length && j >= 0 && chars[i] == chars[j]) {
                i++;
                j--;
            } else
                break;
        }

        return i >= j;
    }
}
