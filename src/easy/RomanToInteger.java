package easy;

/**
 * @Description 13. Roman to Integer
 * See IntegerToRoman.java Description
 * Example 1:
 * Input: "III"
 * Output: 3
 * Example 2:
 * Input: "IV"
 * Output: 4
 * Example 3:
 * Input: "IX"
 * Output: 9
 * Example 4:
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * @Author lzj
 * @Date 2019/4/27 15:45
 */
public class RomanToInteger {
    static class Solution {
        /**
         * 4    IV
         * 9    IX
         * 40   XL
         * 90   XC
         * 400  CD
         * 900  CM
         * @param s
         * @return
         */
        public int romanToInt(String s) {
            int res = 0;
            for (int i=0;i<s.length();i++){
                switch (s.charAt(i)){
                    case 'M':
                        res+=1000;
                        break;
                    case 'D':
                        res+=500;
                        break;
                    case 'C':
                        if (i< s.length()-1 && (s.charAt(i+1) == 'M' || s.charAt(i+1) == 'D'))
                            res-=100;
                        else
                            res+=100;
                        break;
                    case 'L':
                        res+=50;
                        break;
                    case 'X':
                        if (i< s.length()-1 && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C'))
                            res-=10;
                        else
                            res+=10;
                        break;
                    case 'V':
                        res+=5;
                        break;
                    case 'I':
                        if (i< s.length()-1 && (s.charAt(i+1) == 'X' || s.charAt(i+1) == 'V'))
                            res-=1;
                        else
                            res+=1;
                        break;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        String test;
        Solution solution = new Solution();

        test = "III";
        System.out.println("test = " + test + "\t res = " + solution.romanToInt(test) + "\t ac = 3");

        test = "IV";
        System.out.println("test = " + test + "\t res = " + solution.romanToInt(test) + "\t ac = 4");

        test = "IX";
        System.out.println("test = " + test + "\t res = " + solution.romanToInt(test) + "\t ac = 9");

        test = "LVIII";
        System.out.println("test = " + test + "\t res = " + solution.romanToInt(test) + "\t ac = 58");

        test = "MCMXCIV";
        System.out.println("test = " + test + "\t res = " + solution.romanToInt(test) + "\t ac = 1994");
    }
}
