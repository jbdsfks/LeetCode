package medium;

/**
 * @Description 12. Integer to Roman
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * Example 1:
 * Input: 3
 * Output: "III"
 * Example 2:
 * Input: 4
 * Output: "IV"
 * Example 3:
 * Input: 9
 * Output: "IX"
 * Example 4:
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * @Author lzj
 * @Date 2019/4/27 15:04
 */
public class IntegerToRoman {
    static class Solution {
        public String intToRoman(int num) {
            /**
             * 4    IV
             * 9    IX
             * 40   XL
             * 90   XC
             * 400  CD
             * 900  CM
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
            if (num / 500 > 0){
                for (int i = 0; i < num / 500; i++) {
                    res.append("D");
                }
                num = num % 500;
            }
            if (num >= 400) {
                res.append("CD");
                num = num - 400;
            }
            if (num / 100 > 0){
                for (int i = 0; i < num / 100; i++) {
                    res.append("C");
                }
                num = num % 100;
            }
            if (num >= 90) {
                res.append("XC");
                num = num - 90;
            }
            if (num / 50 > 0){
                for (int i = 0; i < num / 50; i++) {
                    res.append("L");
                }
                num = num % 50;
            }
            if (num >= 40) {
                res.append("XL");
                num = num - 40;
            }
            if (num / 10 > 0){
                for (int i = 0; i < num / 10; i++) {
                    res.append("X");
                }
                num = num % 10;
            }
            if (num >= 9) {
                res.append("IX");
                num = num - 90;
            }
            if (num / 5 > 0){
                for (int i = 0; i < num / 5; i++) {
                    res.append("V");
                }
                num = num % 5;
            }
            if (num >= 4) {
                res.append("IV");
                num = num - 4;
            }
            if (num > 0){
                for (int i = 0; i < num ; i++) {
                    res.append("I");
                }
            }

            return res.toString();
        }
    }

    public static void main(String[] args) {
        int test;
        Solution solution = new Solution();

        test = 4;
        System.out.println("test = " + test + "\t res = " + solution.intToRoman(test) + "\t ac = IV");

        test = 3;
        System.out.println("test = " + test + "\t res = " + solution.intToRoman(test) + "\t ac = III");

        test = 9;
        System.out.println("test = " + test + "\t res = " + solution.intToRoman(test) + "\t ac = IX");

        test = 58;
        System.out.println("test = " + test + "\t res = " + solution.intToRoman(test) + "\t ac = LVIII");

        test = 1994;
        System.out.println("test = " + test + "\t res = " + solution.intToRoman(test) + "\t ac = MCMXCIV");
    }
}
