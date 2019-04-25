//package hard;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
///**
// * @Description 10. Regular Expression Matching
// * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
// * '.' Matches any single character.
// * '*' Matches zero or more of the preceding element.
// * The matching should cover the entire input string (not partial).
// * Note:
// * s could be empty and contains only lowercase letters a-z.
// * p could be empty and contains only lowercase letters a-z, and characters like . or *.
// * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
// * '.' 匹配任意单个字符。
// * '*' 匹配零个或多个前面的元素。
// * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
// * 说明:
// * s 可能为空，且只包含从 a-z 的小写字母。
// * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
// * <p>
// * Example 1:
// * Input:
// * s = "aa"
// * p = "a"
// * Output: false
// * Explanation: "a" does not match the entire string "aa".
// * <p>
// * Example 2:
// * Input:
// * s = "aa"
// * p = "a*"
// * Output: true
// * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
// * <p>
// * Example 3:
// * Input:
// * s = "ab"
// * p = ".*"
// * Output: true
// * Explanation: ".*" means "zero or more (*) of any character (.)".
// * <p>
// * Example 4:
// * Input:
// * s = "aab"
// * p = "c*a*b"
// * Output: true
// * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
// * @Author lzj
// * @Date 2019/4/24 15:06
// */
//public class RegularExpressionMatching {
//    static class Solution {
//        public String lastStr(String p) {
//            ArrayList<Character> res = new ArrayList<>();
//            if (p.length() <= 1) {
//                return p.length() > 0 ? p : "";
//            }
//            int j = 0;
//            while (j < p.length()){
//                if (p.charAt(j) != '*') {
//                    res.add(p.charAt(j++));
//                }else if (res.size() > 0){
//                    res.remove(res.size()-1);
//                }else {
//                    j++;
//                }
//            }
//            StringBuilder s = new StringBuilder();
//            for (Character character : res) {
//                s.append(character);
//            }
//            return s.toString();
//        }
//
//        public boolean isMatch(String s, String p) {
//            int i = 0, j = 0;
//            if (s.length() == 0 || p.length() == 0) {
//                return false;
//            }
//            char p_temp = p.charAt(j);
//            while (i < s.length() && j < p.length()) {
//                if (s.charAt(i) == p.charAt(j)) {
//                    if (i < s.length() - 1) i++;
//                    p_temp = p.charAt(j++);
//                } else if (p.charAt(j) == '*') {
//                    if (p_temp == '.' || p_temp == s.charAt(i)) {
//                        if (i < s.length() - 1) i++;
//                    } else {
//                        j++;
//                    }
//                } else if (p.charAt(j) == '.') {
//                    if (i < s.length() - 1) i++;
//                    p_temp = p.charAt(j++);
//                } else if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
//                    j += 2;
//                } else
//                    return false;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        String test_str, test_pattern;
//        Solution solution = new Solution();
//
//        test_str = "aa";
//        test_pattern = "a";
//        System.out.println("test: \n\tstr = " + test_str + "\t pattern = " + test_pattern + "\n\tres = " + solution.isMatch(test_str, test_pattern));
//
//        test_str = "aa";
//        test_pattern = "a*";
//        System.out.println("test: \n\tstr = " + test_str + "\t pattern = " + test_pattern + "\n\tres = " + solution.isMatch(test_str, test_pattern));
//
//        test_str = "ab";
//        test_pattern = ".*";
//        System.out.println("test: \n\tstr = " + test_str + "\t pattern = " + test_pattern + "\n\tres = " + solution.isMatch(test_str, test_pattern));
//
//        test_str = "aab";
//        test_pattern = "c*a*b";
//        System.out.println("test: \n\tstr = " + test_str + "\t pattern = " + test_pattern + "\n\tres = " + solution.isMatch(test_str, test_pattern));
//
//        test_str = "mississippi";
//        test_pattern = "mis*is*p*.";
//        System.out.println("test: \n\tstr = " + test_str + "\t pattern = " + test_pattern + "\n\tres = " + solution.isMatch(test_str, test_pattern));
//
//        test_str = "a";
//        test_pattern = "";
//        System.out.println("test: \n\tstr = " + test_str + "\t pattern = " + test_pattern + "\n\tres = " + solution.isMatch(test_str, test_pattern));
//
//        test_str = "a";
//        test_pattern = "ab*";
//        System.out.println("test: \n\tstr = " + test_str + "\t pattern = " + test_pattern + "\n\tres = " + solution.isMatch(test_str, test_pattern));
//
//        test_str = "aaa";
//        test_pattern = "a*a";
//        System.out.println("test: \n\tstr = " + test_str + "\t pattern = " + test_pattern + "\n\tres = " + solution.isMatch(test_str, test_pattern));
//
//        test_str = "aaa";
//        test_pattern = "aaaa";
//        System.out.println("test: \n\tstr = " + test_str + "\t pattern = " + test_pattern + "\n\tres = " + solution.isMatch(test_str, test_pattern));
//    }
//}
