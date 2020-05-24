/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 *
 * https://leetcode-cn.com/problems/ugly-number-ii/description/
 *
 * algorithms
 * Medium (44.57%)
 * Likes:    88
 * Dislikes: 0
 * Total Accepted:    5.2K
 * Total Submissions: 11.6K
 * Testcase Example:  '10'
 *
 * 编写一个程序，找出第 n 个丑数。
 * 
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * 
 * 示例:
 * 
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 
 * 说明:  
 * 
 * 
 * 1 是丑数。
 * n 不超过1690。
 * 
 * 
 */
class Solution {

    public int minOfThreeNumber(int n1, int n2, int n3) {
        return Math.min(n1, Math.min(n2, n3));
    }

    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        ugly[0] = 1;
        int i = 1;
        while (i < n) {
            int num = minOfThreeNumber(ugly[index1] * 2, ugly[index2] * 3, ugly[index3] * 5);
            if (num == ugly[index1] * 2) {
                index1++;
            }
            if (num == ugly[index2] * 3) {
                index2++;
            }
            if (num == ugly[index3] * 5) {
                index3++;
            }
            ugly[i] = num;
            i++;
        }
        return ugly[n - 1];
    }
}
