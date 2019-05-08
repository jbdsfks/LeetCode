package easy;

import java.util.Stack;

/**
 * @Description 1021. Remove Outermost Parentheses
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
 * A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.
 * Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
 * Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
 * Example 1:
 * Input: "(()())(())"
 * Output: "()()()"
 * Explanation:
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 * Example 2:
 * Input: "(()())(())(()(()))"
 * Output: "()()()()(())"
 * Explanation:
 * The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
 * After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
 * Example 3:
 * Input: "()()"
 * Output: ""
 * Explanation:
 * The input string is "()()", with primitive decomposition "()" + "()".
 * After removing outer parentheses of each part, this is "" + "" = "".
 * Note:
 * S.length <= 10000
 * S[i] is "(" or ")"
 * S is a valid parentheses string
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 * 示例 1：
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * 示例 2：
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每隔部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * 示例 3：
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 * 提示：
 * S.length <= 10000
 * S[i] 为 "(" 或 ")"
 * S 是一个有效括号字符串
 * @Author lzj
 * @Date 2019/5/8 13:09
 */
public class RemoveOutermostParentheses {
    static class Solution {
        public String removeOuterParentheses(String S) {
            StringBuilder stringBuilder = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            for(char c:S.toCharArray()){
                if (c == '(') {
                    if (!stack.empty())
                        stringBuilder.append(c);
                    stack.push(c);
                }
                else {
                    stack.pop();
                    if (!stack.empty())
                        stringBuilder.append(c);
                }
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"(()())(())", "(()())(())(()(()))", "()()"};
        String[] acs = new String[]{"()()()", "()()()()(())", ""};
        Solution solution = new Solution();
        for (int i = 0; i < strings.length; i++) {
            System.out.println("input = " + strings[i] + "\t ac = " + acs[i] + "\t res = " + solution.removeOuterParentheses(strings[i]));
        }
    }
}
