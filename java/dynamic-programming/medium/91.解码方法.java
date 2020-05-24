/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (21.46%)
 * Likes:    163
 * Dislikes: 0
 * Total Accepted:    12K
 * Total Submissions: 55.9K
 * Testcase Example:  '"12"'
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 
 * 示例 1:
 * 
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 
 */

/**
 * 回溯发
 */
class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0')
            return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= s.length(); i++){
            if(s.charAt(i-1) != '0'){
                dp[i] += dp[i-1];
            }
            if((s.charAt(i-2) == '1') || (s.charAt(i-2) == '2' && s.charAt(i-1) <= '6')){
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
