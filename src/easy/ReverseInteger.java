package easy;

import java.util.ArrayList;

/**
 * @Description 7. Reverse Integer
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * Example 1:
 * Input: 123
 * Output: 321
 * Example 2:
 * Input: -123
 * Output: -321
 * Example 3:
 * Input: 120
 * Output: 21
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31−1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @Author lzj
 * @Date 2019/4/24 13:48
 */
public class ReverseInteger {
    static class Solution {
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
//                System.out.println(res.get(0));
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

    public static void main(String[] args) {
        int test_int, res_int;

        Solution solution = new Solution();
        test_int = 0;
        res_int = solution.reverse(test_int);
        System.out.println(res_int);

        test_int = -1;
        res_int = solution.reverse(test_int);
        System.out.println(res_int);

        test_int = 12312;
        res_int = solution.reverse(test_int);
        System.out.println(res_int);

        test_int = -12331;
        res_int = solution.reverse(test_int);
        System.out.println(res_int);
    }
}
