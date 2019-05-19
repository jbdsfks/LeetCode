package medium;

import java.util.PriorityQueue;

/**
 * @Description 313. Super Ugly Number
 * Write a program to find the n^th super ugly number.
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 * Example:
 * Input: n = 12, primes = [2,7,13,19]
 * Output: 32
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
 * super ugly numbers given primes = [2,7,13,19] of size 4.
 * Note:
 * 1 is a super ugly number for any given primes.
 * The given numbers in primes are in ascending order.
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 * 编写一段程序来查找第 n 个超级丑数。
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 * 示例:
 * 输入: n = 12, primes = [2,7,13,19]
 * 输出: 32
 * 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * 说明:
 * 1 是任何给定 primes 的超级丑数。
 * 给定 primes 中的数字以升序排列。
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
 * 第 n 个超级丑数确保在 32 位有符整数范围内。
 * @Author lzj
 * @Date 2019/5/17 14:14
 */
public class SuperUglyNumber {
    static class Solution {
        /**
         * 思路与 UglyNumberII 类似，只是质因数的个数与数值变成了可变项。
         * @param n
         * @param primes
         * @return
         */
        public int nthSuperUglyNumber(int n, int[] primes) {
            int[] ugly = new int[n];
            ugly[0] = 1;
            int[] index = new int[primes.length];
            int[] temp_ugly = new int[primes.length];
            for (int i = 1; i < n; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < primes.length; j++) {
                    temp_ugly[j] =  ugly[index[j]] * primes[j];
                    min = Math.min(min, temp_ugly[j]);
                }
                for (int j = 0; j < primes.length; j++) {
                    if (temp_ugly[j] == min)
                        index[j] = index[j] + 1;
                }
                ugly[i] = min;
            }
            return ugly[n - 1];
        }
    }

    public static void main(String[] args) {
        int[] primes = new int[]{
          2,7,13,19
        };
        int n = 12;
        Solution solution = new Solution();
        System.out.println(solution.nthSuperUglyNumber(n, primes));
    }
}
