package medium;

/**
 * @Description 6.ZigZag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * @Author lzj
 * @Date 2019/4/17 14:15
 */
public class ZigZagConversion {

    static class Solution {
        String convert(String s, int numRows) {
            if (numRows == 1)
                return s;
            int size = 2 * numRows - 2;
            int T = s.length() / size + 1;
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < T; j++) {
                    if((i + j * size) <= s.length() -1)
                        res.append(s.charAt(i + j * size));
                    if(i != 0 && i != numRows-1 && (size - i + j * size) <= s.length() - 1)
                        res.append(s.charAt(size - i + j * size));
                }
            }
            return res.toString();
        }
    }

    public static void main(String[] args) {
        String s, res, result;
        int line;
        Solution solution = new Solution();
        s = "LEETCODEISHIRING";
        result = "LDREOEIIECIHNTSG";
        line = 4;
        res = solution.convert(s, line);
        System.out.println("res = " + res+"\nis_pass = "+(res.equals(result)));
    }
}
