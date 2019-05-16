package medium;

/**
 * @Description 264. Ugly Number II
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * Example:
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 * 编写一个程序，找出第 n 个丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 * 1 是丑数。
 * n 不超过1690。
 * @Author lzj
 * @Date 2019/5/16 19:45
 */
public class UglyNumberII {
    static class Solution {

        public int minOfThreeNumber(int n1, int n2, int n3) {
            return Math.min(n1, Math.min(n2,n3));
        }

        /**
         * 普通思路方法会超时，这里一个丑数生成规律解
         * 首先，后面的丑数都是由前面的某个丑数 *2， *3， *5 得到的，如
         *  index: 0    1   2   3   4   5   6   7   8   9   10
         * ugly[]: 1    2   3   4   5   6   8   9   10  12  14
         * i2 = i3 = i5 = 0;
         *          i2          i3            i5            i2  i3  i5
         * min{ugly[0] * 2, ugly[0] * 3, ugly[0] * 5} = min{2, 3, 5} = 2; use i2;
         * min{ugly[1] * 2, ugly[0] * 3, ugly[0] * 5} = min{4, 3, 5} = 3; use i3;
         * min{ugly[1] * 2, ugly[1] * 3, ugly[0] * 5} = min{4, 6, 5} = 4; use i2;
         * min{ugly[2] * 2, ugly[1] * 3, ugly[0] * 5} = min{6, 6, 5} = 5; use i5;
         * min{ugly[2] * 2, ugly[1] * 3, ugly[1] * 5} = min{6, 6, 10} = 6; use i2,i3;
         * min{ugly[3] * 2, ugly[2] * 3, ugly[1] * 5} = min{8, 9, 10} = 6; use i2;
         * 由此可看出，每个丑数都可从某个丑数 *2， *3， *5 得到的最小值中产生，其中得到最小的相应丑数 i 索引 +1 ；
         * 最后 ugly[] 中最后一个就是要找的。
         * @param n
         * @return
         */
        public int nthUglyNumber(int n) {
            int[] ugly = new int[n];
            int index1 = 0;
            int index2 = 0;
            int index3 = 0;
            ugly[0] = 1;
            int i = 1;
            while (i<n) {
                int num = minOfThreeNumber(ugly[index1] * 2, ugly[index2] * 3, ugly[index3] * 5);
                if (num == ugly[index1] * 2){
                    index1++;
                }
                if (num == ugly[index2] * 3){
                    index2++;
                }
                if (num == ugly[index3] * 5){
                    index3++;
                }
                ugly[i] = num;
                i++;
            }
            return ugly[n-1];
        }
    }

    public static void main(String[] args) {
        int n = 2;
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(10));
    }
}
