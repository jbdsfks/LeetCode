package easy;

/**
 * @Description 844. Backspace String Compare
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * Example 1:
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * Follow up:
 * Can you solve it in O(N) time and O(1) space?
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 示例 1：
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * 提示：
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 * @Author lzj
 * @Date 2019/5/8 12:42
 */
public class BackspaceStringCompare {
    static class Solution {
        public String getStringOfBackspaceCompare(String s){
            StringBuilder stringBuilder = new StringBuilder();
            for (char c:s.toCharArray()) {
                if (c == '#') {
                    if (stringBuilder.length() > 0)
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                else
                    stringBuilder.append(c);
            }
            return stringBuilder.toString();
        }

        public boolean backspaceCompare(String S, String T) {
            return getStringOfBackspaceCompare(S).equals(getStringOfBackspaceCompare(T));
        }
    }

    public static void main(String[] args) {
        String[] Ss = new String[]{"xywrrmp", "ab#c", "ab##", "a##c", "a#c", };
        String[] Ts = new String[]{"xywrrmu#p", "ab#c", "c#d#", "#a#c", "b", };
        boolean[] acs = new boolean[]{true, true, true, true, false};
        Solution solution = new Solution();

        for (int i = 0; i < Ss.length; i++) {
            System.out.println("S = " + Ss[i] + "\t T = " + Ts[i] + "\t ac = " + acs[i] + "\t res = " + solution.backspaceCompare(Ss[i], Ts[i]));
        }
    }
}
