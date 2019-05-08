//package medium;
//
//import java.util.TreeMap;
//
///**
// * @Description 424. Longest Repeating Character Replacement
// * Given a string that consists of only uppercase English letters,
// * you can replace any letter in the string with another letter at most k times.
// * Find the length of a longest substring containing all repeating letters you can get after performing the above operations.
// * Note:
// * Both the string's length and k will not exceed 10^4.
// * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。
// * 在执行上述操作后，找到包含重复字母的最长子串的长度。
// * 注意:
// * 字符串长度 和 k 不会超过 104。
// * Example 1:
// * Input:
// * s = "ABAB", k = 2
// * Output:
// * 4
// * Explanation:
// * Replace the two 'A's with two 'B's or vice versa.
// * Example 2:
// * Input:
// * s = "AABABBA", k = 1
// * Output:
// * 4
// * Explanation:
// * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// * The substring "BBBB" has the longest repeating letters, which is 4.
// * @Author lzj
// * @Date 2019/5/6 9:59
// */
//public class LongestRepeatingCharacterReplacement {
//    static class Solution {
//
//        public int characterReplacement(String s, int k) {
//            if (s.length() == 0)
//                return 0;
//            int max_num = k + 1;
//            int start = 0, end = 0, cur = 1;
//            for (int i = 0; i < s.length() - k; i++) {
//
//            }
//            return max_num;
//        }
//    }
//
//    public static void main(String[] args) {
//        String[] strings;
//        int[] ks;
//        int[] acs;
//        Solution solution = new Solution();
//
//        strings = new String[]{
//                "IMNJJTRMJEGMSOLSCCQICIHLQIOGBJAEHQOCRAJQMBIBATGLJDTBNCPIFRDLRIJHRABBJGQAOLIKRLHDRIGERENNMJSDSSMESSTR",
//                "BBBB",
//                "ABAB",
//                "AABABBA",
//        };
//        ks = new int[]{
//                2,
//                0,
//                2,
//                1,
//        };
//        acs = new int[]{
//                6,
//                4,
//                4,
//                4
//        };
//        for (int i = 0; i < strings.length; i++) {
//            System.out.println("s = " + strings[i] + "\t k = " + ks[i] + "\t res = " + solution.characterReplacement(strings[i], ks[i]) + "\t ac = " + acs[i]);
//        }
//    }
//}
