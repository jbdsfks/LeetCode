/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 *
 * https://leetcode-cn.com/problems/integer-to-roman/description/
 *
 * algorithms
 * Medium (59.12%)
 * Likes:    150
 * Dislikes: 0
 * Total Accepted:    24.4K
 * Total Submissions: 41.3K
 * Testcase Example:  '3'
 *
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V +
 * II 。
 * 
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数
 * 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * 
 * 
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 
 * 
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * 
 * 示例 1:
 * 
 * 输入: 3
 * 输出: "III"
 * 
 * 示例 2:
 * 
 * 输入: 4
 * 输出: "IV"
 * 
 * 示例 3:
 * 
 * 输入: 9
 * 输出: "IX"
 * 
 * 示例 4:
 * 
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 
 * 
 * 示例 5:
 * 
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * 
 */
class Solution {
    public String intToRoman(int num) {
        /**
         * 4 IV 9 IX 40 XL 90 XC 400 CD 900 CM
         */
        StringBuilder res = new StringBuilder();
        if (num / 1000 > 0) {
            for (int i = 0; i < num / 1000; i++) {
                res.append("M");
            }
            num = num % 1000;
        }
        if (num >= 900) {
            res.append("CM");
            num = num - 900;
        }
        if (num / 500 > 0) {
            for (int i = 0; i < num / 500; i++) {
                res.append("D");
            }
            num = num % 500;
        }
        if (num >= 400) {
            res.append("CD");
            num = num - 400;
        }
        if (num / 100 > 0) {
            for (int i = 0; i < num / 100; i++) {
                res.append("C");
            }
            num = num % 100;
        }
        if (num >= 90) {
            res.append("XC");
            num = num - 90;
        }
        if (num / 50 > 0) {
            for (int i = 0; i < num / 50; i++) {
                res.append("L");
            }
            num = num % 50;
        }
        if (num >= 40) {
            res.append("XL");
            num = num - 40;
        }
        if (num / 10 > 0) {
            for (int i = 0; i < num / 10; i++) {
                res.append("X");
            }
            num = num % 10;
        }
        if (num >= 9) {
            res.append("IX");
            num = num - 90;
        }
        if (num / 5 > 0) {
            for (int i = 0; i < num / 5; i++) {
                res.append("V");
            }
            num = num % 5;
        }
        if (num >= 4) {
            res.append("IV");
            num = num - 4;
        }
        if (num > 0) {
            for (int i = 0; i < num; i++) {
                res.append("I");
            }
        }

        return res.toString();
    }
}
