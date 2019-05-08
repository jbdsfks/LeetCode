package easy;

import java.util.Stack;

/**
 * @Description 20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * Example 1:
 * Input: "()"
 * Output: true
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * Input: "(]"
 * Output: false
 * Example 4:
 * Input: "([)]"
 * Output: false
 * Example 5:
 * Input: "{[]}"
 * Output: true
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * @Author lzj
 * @Date 2019/5/7 19:34
 */
public class ValidParentheses {
    static class Solution {
        public boolean isParenthes(Character c1, Character c2){
            switch (c1){
                case '(':
                    return c2.equals(')');
                case '[':
                    return c2.equals(']');
                case '{':
                    return c2.equals('}');
            }
            return false;
        }

        public boolean isValid(String s) {
            if (s.length() == 0)
                return true;
            Stack<Character> stack = new Stack<>();
            for (Character c:s.toCharArray()){
                if (stack.empty())
                    stack.push(c);
                else if(!isParenthes(stack.peek(), c)){
                    stack.push(c);
                }else {
                    stack.pop();
                }
            }
            return stack.empty();
        }
    }

    public static void main(String[] args) {
        String[] strings;
        boolean[] acs;
        Solution solution = new Solution();

        strings = new String[]{
                "(){}[]",
                "([])",
                "(["
        };
        acs = new boolean[]{
                true,
                true,
                false
        };

        for (int i = 0; i < strings.length; i++) {
            System.out.println("input = " + strings[i] + "\t ac = " + acs[i] + "\t res = " + solution.isValid(strings[i]));
        }
    }
}
