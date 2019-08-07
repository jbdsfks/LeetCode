/*
 * @lc app=leetcode.cn id=784 lang=java
 *
 * [784] 字母大小写全排列
 *
 * https://leetcode-cn.com/problems/letter-case-permutation/description/
 *
 * algorithms
 * Easy (54.79%)
 * Likes:    74
 * Dislikes: 0
 * Total Accepted:    5K
 * Total Submissions: 9K
 * Testcase Example:  '"a1b2"'
 *
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * 
 * 
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * 
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 * 
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 
 * 
 * 注意：
 * 
 * 
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 * 
 * 
 */
class Solution {
    List<String> res = new ArrayList<>();
    public void dfs(StringBuilder stringBuilder, int cur){
        if(stringBuilder.length() == cur){
            res.add(stringBuilder.toString());
            return;
        }
        if(Character.isDigit(stringBuilder.charAt(cur))){
            dfs(stringBuilder, cur + 1);
        }else{
            char ch = stringBuilder.charAt(cur);
            stringBuilder.setCharAt(cur, Character.toLowerCase(ch));
            dfs(stringBuilder, cur+1);
            stringBuilder.setCharAt(cur, Character.toUpperCase(ch));
            dfs(stringBuilder, cur+1);
        }
    }
    public List<String> letterCasePermutation(String S) {
        dfs(new StringBuilder(S), 0);
        return res;
    }
}

