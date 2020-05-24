/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (33.44%)
 * Likes:    556
 * Dislikes: 0
 * Total Accepted:    82.1K
 * Total Submissions: 245.6K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 
 * 
 * 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 * 
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        StringBuilder s = new StringBuilder();
        int i = 0;
        String temp = strs[0];
        boolean stop = false;
        while (i < temp.length() && !stop) {
            boolean append = true;
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    stop = true;
                    append = false;
                    break;
                }
                if (strs[j].charAt(i) != temp.charAt(i)) {
                    append = false;
                    break;
                }
            }
            if (append)
                s.append(temp.charAt(i));
            else
                stop = true;
            i++;
        }
        return s.toString();
    }
}
