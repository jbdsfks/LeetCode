//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串
     *
     * @param s 给定字符串
     * @return true，能/false，不能
     */
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                break;
            }
        }
        return left >= right
                || validPalindrome(s, left + 1, right)
                || validPalindrome(s, left, right - 1);
    }

    /**
     * 给定字符串是否从[left，right]子串为回文字符串
     *
     * @param s     待判字符串
     * @param left  限定子串起始下标，包含边界
     * @param right 限定子串终止下标，包含边界
     * @return true，是/false，不是
     */
    public boolean validPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
