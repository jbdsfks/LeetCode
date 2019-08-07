import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (49.21%)
 * Likes:    333
 * Dislikes: 0
 * Total Accepted:    26.4K
 * Total Submissions: 53.4K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 */
class Solution {
    List<String> res = new ArrayList<>();
    List<Character[]> dic = new ArrayList<>();

    public void dfs(StringBuilder stringBuilder, int cur) {
        if (stringBuilder.length() == cur) {
            res.add(stringBuilder.toString());
            return;
        }
        int nums = (int) stringBuilder.charAt(cur) - (int) '0';
        for (int i = 0; i < dic.get(nums - 2).length; i++) {
            char ch = stringBuilder.charAt(cur);
            stringBuilder.setCharAt(cur, dic.get(nums - 2)[i]);
            dfs(stringBuilder, cur + 1);
            stringBuilder.setCharAt(cur, ch);
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.equals(""))
            return res;
        dic.add(new Character[] { 'a', 'b', 'c' });
        dic.add(new Character[] { 'd', 'e', 'f' });
        dic.add(new Character[] { 'g', 'h', 'i' });
        dic.add(new Character[] { 'j', 'k', 'l' });
        dic.add(new Character[] { 'm', 'n', 'o' });
        dic.add(new Character[] { 'p', 'q', 'r', 's' });
        dic.add(new Character[] { 't', 'u', 'v' });
        dic.add(new Character[] { 'w', 'x', 'y', 'z' });
        dfs(new StringBuilder(digits), 0);
        return res;
    }
}
