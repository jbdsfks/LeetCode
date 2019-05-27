/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (32.43%)
 * Likes:    1043
 * Dislikes: 0
 * Total Accepted:    127.3K
 * Total Submissions: 392.7K
 * Testcase Example:  '123'
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1:
 * 
 * 输入: 123
 * 输出: 321
 * 
 * 
 * 示例 2:
 * 
 * 输入: -123
 * 输出: -321
 * 
 * 
 * 示例 3:
 * 
 * 输入: 120
 * 输出: 21
 * 
 * 
 * 注意:
 * 
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回
 * 0。
 * 
 */
class Solution {
    int reverse(int x) {
        boolean is_z = true;
        if (x < 0) {
            is_z = false;
            x = x * -1;
        }
        long res_long = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (x / 10 > 0) {
            res.add(x % 10);
            x /= 10;
        }
        res.add(x);
        while (!res.isEmpty()) {
            // System.out.println(res.get(0));
            res_long = res_long * 10 + res.get(0);
            res.remove(0);
        }
        res_long = is_z ? res_long : -1 * res_long;
        if (res_long > Integer.MAX_VALUE || res_long < Integer.MIN_VALUE)
            return 0;
        else
            return (int) res_long;
    }
}
