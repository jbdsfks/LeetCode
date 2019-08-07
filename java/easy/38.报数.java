/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 报数
 *
 * https://leetcode-cn.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (50.09%)
 * Likes:    236
 * Dislikes: 0
 * Total Accepted:    31.7K
 * Total Submissions: 63.3K
 * Testcase Example:  '1'
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 
 * 注意：整数顺序将表示为一个字符串。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: "1"
 * 
 * 
 * 示例 2:
 * 
 * 输入: 4
 * 输出: "1211"
 * 
 * 
 */
class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String res = "1";
        /*
         * n >= 2 从 "1" 开始，转成chars，然后统计同一个char的出现次数 count ，统计过后，append
         */
        for (int i = 1; i < n; i++) {
            // 默认至少一次
            int count = 1;
            // 转换成chars
            char[] chars = res.toCharArray();
            // 比对ch， 初始化默认取第一个char
            char ch = chars[0];
            StringBuilder stringBuilder = new StringBuilder();
            // 从第二个char开始
            for (int j = 1; j < chars.length; j++) {
                // 相等，则计数器++
                if (chars[j] == ch) {
                    count++;
                } else {
                    // 不相等，append
                    stringBuilder.append(count); // count为多少，代表出现了几次ch，因此append(count)
                    stringBuilder.append(ch);
                    ch = chars[j]; // 修改比对ch
                    count = 1; // 恢复为一次
                }
            }
            // 用于append最后一个ch出现的次数。
            stringBuilder.append(count);
            stringBuilder.append(ch);
            res = stringBuilder.toString();
        }
        return res;
    }
}
