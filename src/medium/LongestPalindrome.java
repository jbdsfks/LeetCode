package medium;

/**
 * @Description 5. Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 * @Author lzj
 * @Date 2019/4/17 13:31
 */
public class LongestPalindrome {
    static class Solution {
        boolean isPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return false;
            }
            int i = 0, j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i) == s.charAt(j)) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
            return true;
        }

        String longestPalindrome(String s) {
            boolean is_ok = false;
            if (isPalindrome(s)) {
                return s;
            }
            String res = "";
            for (int i = 0; i < s.length() - 1; i++) {
                int j = s.lastIndexOf(s.charAt(i));

                while (i <= j) {
                    String temp = s.substring(i, j + 1);
                    if (isPalindrome(temp)) {
                        res = res.length() > temp.length() ? res : temp;
                        break;
                    } else {
                        j = i + s.substring(i, j).lastIndexOf(s.charAt(i));
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        String s, res;
        Solution solution = new Solution();
        s = "abcdbbfcba";
        res = solution.longestPalindrome((s));
        System.out.println("s = " + s + "\nres = " + res);
    }
}
