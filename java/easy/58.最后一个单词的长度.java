/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 *
 * https://leetcode-cn.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (29.99%)
 * Likes:    106
 * Dislikes: 0
 * Total Accepted:    27.9K
 * Total Submissions: 93.1K
 * Testcase Example:  '"Hello World"'
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 
 * 如果不存在最后一个单词，请返回 0 。
 * 
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * 
 * 示例:
 * 
 * 输入: "Hello World"
 * 输出: 5
 * 
 * 
 */
class Solution {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        int length = chars.length;
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] == ' ')
                if (length - 1 == i)
                    length--;
                else
                    break;
            else
                count++;
        }
        return count;
    }
}
