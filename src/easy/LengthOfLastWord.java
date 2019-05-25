package easy;

/**
 * @Description 58. Length of Last Word
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 * @Author lzj
 * @Date 2019/5/25 20:21
 */
public class LengthOfLastWord {
    class Solution {
        public int lengthOfLastWord(String s) {
//            String[] array = s.split(" ");
//            return array.length > 1?array[array.length-1].length():0;
            char[] chars = s.toCharArray();
            int count = 0;
            int length = chars.length;
            for (int i = length-1;i>=0;i--){
                if (chars[i] == ' ')
                    if (length - 1 == i)
                        length--;
                    else
                        break;
                else count++;
            }
            return count;
        }
    }
}
