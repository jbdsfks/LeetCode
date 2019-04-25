package medium;

/**
 * @Description 3. Longest Substring Without Repeating Characters(无重复字符的最长子串)
 * Given a string, find the length of the longest substring without repeating characters.
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * @Author lzj
 * @Date 2019/4/15 19:10
 */
public class LengthOfLongestSubstring {

    private static int lengthOfLongestSubstring(String s) {
        int res = 0;
        if(s.equals(""))
            return res;
        StringBuilder sub_s = new StringBuilder(String.valueOf(s.charAt(0)));
        int fromIndex = 0;
        for (int i = 1; i < s.length(); i++) {
            String s_temp = String.valueOf(s.charAt(i));
            if (!sub_s.toString().contains(s_temp)) {
                sub_s.append(s_temp);
            } else {
                res = res > sub_s.length() ? res : sub_s.length();
                i = s.indexOf(s_temp, fromIndex) + 1;
                fromIndex = i;
                sub_s = new StringBuilder(String.valueOf(s.charAt(i)));
            }
        }
        return res > sub_s.length() ? res : sub_s.length();
    }

    public static void main(String[] args) {
        String s = "dvdf";
        int res = lengthOfLongestSubstring(s);
        System.out.println(s+":"+res);

        s = "aaaa";
        res = lengthOfLongestSubstring(s);
        System.out.println(s+":"+res);

        s = "abcabcaa";
        res = lengthOfLongestSubstring(s);
        System.out.println(s+":"+res);

        s = "";
        res = lengthOfLongestSubstring(s);
        System.out.println(s+":"+res);
    }
}
