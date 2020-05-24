package test;

/**
 * @Description
 * @Author lzj
 * @Date 2020/5/24 22:02
 */

class Solution {
    public boolean validPalindromeCode(String s, int start, int end, boolean isDeleted){
        if (start >= end){
            return true;
        }
        if (s.charAt(start) == s.charAt(end)){
            return validPalindromeCode(s, start + 1, end - 1, isDeleted);
        }else {
            if (isDeleted){
                return false;
            }
            if ((start + 1) <= end && s.charAt(start + 1) == s.charAt(end)){
                return validPalindromeCode(s, start+1, end, true);
            }
            if (start <= (end - 1) && s.charAt(start) == s.charAt(end - 1)){
                return validPalindromeCode(s, start, end - 1, true);
            }
            return false;
        }

    }

    public boolean validPalindrome(String s) {
        if (null == s || s.length() <= 1)
            return true;
        return validPalindromeCode(s, 0, s.length() - 1, false);
    }
}
public class Test {
    public static void main(String[] args) {
        String s = "ebcbbececabbacecbbcbe";
        Solution solution = new Solution();
        System.out.println(solution.validPalindrome(s));
    }
}
