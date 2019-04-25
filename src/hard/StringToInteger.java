package hard;

/**
 * @Description 8.String to Integer (atoi)
 * Implement atoi which converts a string to an integer.
 * The function first discards as many whitespace characters as necessary
 * until the first non-whitespace character is found.
 * Then, starting from this character,
 * takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 * and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number,
 * which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters,
 * no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned.
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * Note:
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * If the numerical value is out of the range of representable values, INT_MAX (2^31 − 1) or INT_MIN (−2^31) is returned.
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，
 * 返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * Example 1:
 * Input: "42"
 * Output: 42
 * Example 2:
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−231) is returned.
 * @Author lzj
 * @Date 2019/4/24 14:18
 */
public class StringToInteger {
    static class Solution {
        int myAtoi(String str) {
            str = str.trim();
//            System.out.println(str);
            boolean is_z = true;
            long res_long = 0;
            if (str.equals("") || str.charAt(0) != '-' && str.charAt(0) != '+' && (str.charAt(0) < '0' || str.charAt(0) > '9'))
                return 0;
            if ((str.charAt(0) == '-' || str.charAt(0) == '+')) {
                is_z = str.charAt(0) != '-';
                str = str.substring(1);
            }
//            System.out.println(str);
            int i = 0;
            while (i < str.length()) {
                if ((str.charAt(i) < '0' || str.charAt(i) > '9'))
                    break;
                res_long = res_long * 10 + (str.charAt(i) - '0');
                res_long = is_z ? res_long : res_long * -1;
                if (res_long > Integer.MAX_VALUE || res_long < Integer.MIN_VALUE){
                    return res_long > Integer.MAX_VALUE?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                res_long = is_z ? res_long : res_long * -1;
//                System.out.println(res_long);
                i++;
            }
            res_long = is_z ? res_long : res_long * -1;
            return (int) res_long;
        }
    }

    public static void main(String[] args) {
        String test_str;
        Solution solution = new Solution();
//        test_str = "asdas 123";
//        System.out.println(solution.myAtoi(test_str));
//        test_str = "   -123";
//        System.out.println(solution.myAtoi(test_str));
//        test_str = "    +123";
//        System.out.println(solution.myAtoi(test_str));
//        test_str = " 1123122312312323";
//        System.out.println(solution.myAtoi(test_str));
//        test_str = "   -1000 asd 123";
//        System.out.println(solution.myAtoi(test_str));

        test_str = "-91283472332";
        System.out.println(solution.myAtoi(test_str));
    }
}
