import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 *
 * https://leetcode-cn.com/problems/word-break/description/
 *
 * algorithms
 * Medium (42.47%)
 * Likes:    167
 * Dislikes: 0
 * Total Accepted:    15K
 * Total Submissions: 35.4K
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 
 * 说明：
 * 
 * 
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 
 * 
 * 示例 1：
 * 
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 
 * 
 * 示例 2：
 * 
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * 
 * 
 * 示例 3：
 * 
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * 
 * 
 */
class Solution {
    /**
     * 递归回溯法超时
     */
    /*
    public boolean backTrack(String s, HashSet<String> wordDict, int start){
        if(start == s.length())
            return true;
        for(int end = start + 1; end <= s.length(); end++){
            if(wordDict.contains(s.substring(start,end)) && backTrack(s, wordDict, end)){
                return true;
            }
        }
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        return backTrack(s, new HashSet<String>(wordDict), 0);
    }
    */

    /**
     * 记忆回溯法
     * √ Accepted
     * √ 36/36 cases passed (17 ms)
     * √ Your runtime beats 45.52 % of java submissions
     * √ Your memory usage beats 25.03 % of java submissions (43.2 MB)
     */ 
    /*
    public boolean backTrack(String s, HashSet<String> wordDict, int start, Boolean[] memo){
        if(start == s.length())
            return true;
        if(memo[start] != null)
            return memo[start];
        for(int end = start + 1; end <= s.length(); end++){
            if(wordDict.contains(s.substring(start,end)) && backTrack(s, wordDict, end, memo)){
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        return backTrack(s, new HashSet<String>(wordDict), 0, new Boolean[s.length()]);
    }
    */

    /**
     * 宽度优先搜索
     * √ Accepted
     * √ 36/36 cases passed (21 ms)
     * √ Your runtime beats 12.93 % of java submissions
     * √ Your memory usage beats 31 % of java submissions (42.6 MB)
     */
    /*
    public boolean wordBreak(String s, List<String> wordDict){
        Set<String> set = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[s.length()];
        while(!queue.isEmpty()){
            int start = queue.remove();
            if(!visited[start]){
                for(int end = start + 1; end <= s.length(); end++){
                    if(set.contains(s.substring(start, end))){
                        if(end == s.length())
                            return true;
                        queue.add(end);
                    }
                }
                visited[start] = true;
            }
        }
        return false;
    }
    */

    /**
     * dp
     * √ Accepted
     * √ 36/36 cases passed (20 ms)
     * √ Your runtime beats 22.97 % of java submissions
     * √ Your memory usage beats 36.13 % of java submissions (42.3 MB)
     */
    public boolean wordBreak(String s, List<String> wordDict){
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i<=s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

