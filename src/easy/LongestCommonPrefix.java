package easy;

/**
 * @Description 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * All given inputs are in lowercase letters a-z.
 * @Author lzj
 * @Date 2019/4/27 16:06
 */
public class LongestCommonPrefix {
    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0)
                return "";
            if (strs.length == 1)
                return strs[0];
            StringBuilder s = new StringBuilder();
            int i = 0;
            String temp = strs[0];
            boolean stop = false;
            while (i<temp.length() && !stop){
                boolean append = true;
                for (int j = 1; j<strs.length;j++){
                    if (i >= strs[j].length()){
                        stop = true;
                        append = false;
                        break;
                    }
                    if (strs[j].charAt(i) != temp.charAt(i)){
                        append = false;
                        break;
                    }
                }
                if (append)
                    s.append(temp.charAt(i));
                else
                    stop = true;
                i++;
            }
            return s.toString();
        }
    }

    public static void main(String[] args) {
        String[] test;
        Solution solution = new Solution();

        test = new String[]{"flower", "flow", "flight"};
        System.out.println("test = {\"flower\",\"flow\",\"flight\"} \t res = "+solution.longestCommonPrefix(test)+" \t ac = \"fl\"");

        test = new String[]{"dog","racecar","car"};
        System.out.println("test = {\"dog\",\"racecar\",\"car\"} \t res = "+solution.longestCommonPrefix(test)+" \t ac = \"\"");
    }
}
