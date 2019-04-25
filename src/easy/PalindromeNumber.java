package easy;

/**
 * @Description 9.Palindrome Number
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * Example 1:
 * Input: 121
 * Output: true
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * @Author lzj
 * @Date 2019/4/24 14:57
 */
public class PalindromeNumber {
    static class Solution {
        boolean isPalindrome(int x) {
            if (x < 0)
                return false;
            char[] chars = String.valueOf(x).toCharArray();
            int i = 0, j = chars.length - 1;
            while (i <= j) {
                if (chars[i] != chars[j])
                    return false;
                i++;
                j--;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int test_int;
        Solution solution = new Solution();

        test_int = 121;
        System.out.println("test value = " + test_int + "\nresult = " + solution.isPalindrome(test_int));
        test_int = -121;
        System.out.println("test value = " + test_int + "\nresult = " + solution.isPalindrome(test_int));
        test_int = 1;
        System.out.println("test value = " + test_int + "\nresult = " + solution.isPalindrome(test_int));
        test_int = 1010;
        System.out.println("test value = " + test_int + "\nresult = " + solution.isPalindrome(test_int));

    }
}
