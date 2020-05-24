/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 *
 * https://leetcode-cn.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (48.38%)
 * Likes:    197
 * Dislikes: 0
 * Total Accepted:    25.7K
 * Total Submissions: 53K
 * Testcase Example:  '"11"\n"1"'
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 
 * 输入为非空字符串且只包含数字 1 和 0。
 * 
 * 示例 1:
 * 
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 
 * 示例 2:
 * 
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 
 */
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int sub = Math.abs(a.length() - b.length());
        if (a.length() < b.length())
            a = String.format("%0" + sub + "d", 0).concat(a);
        else if (a.length() > b.length())
            b = String.format("%0" + sub + "d", 0).concat(b);
        int sum = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int n1 = Integer.parseInt(String.valueOf(a.charAt(i)));
            int n2 = Integer.parseInt(String.valueOf(b.charAt(i)));
            int tempSum = sum + n1 + n2;
            stringBuilder.append(tempSum % 2);
            sum = tempSum / 2;
        }
        if (sum > 0) {
            stringBuilder.append(sum);
        }
        return stringBuilder.reverse().toString();
    }
}
