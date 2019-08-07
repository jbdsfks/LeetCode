/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 第k个排列
 *
 * https://leetcode-cn.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Medium (46.17%)
 * Likes:    82
 * Dislikes: 0
 * Total Accepted:    8.8K
 * Total Submissions: 19.1K
 * Testcase Example:  '3\n3'
 *
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * 给定 n 和 k，返回第 k 个排列。
 * 
 * 说明：
 * 
 * 
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 
 * 
 * 示例 1:
 * 
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 
 * 
 * 示例 2:
 * 
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * 
 * 
 */
class Solution {
    int k;
    String res = "";
    int[] visited;

    public void dfs(StringBuilder stringBuilder, int cur, int n) {
        if (this.k == 0)
            return;
        if (n == cur) {
            // System.out.println(stringBuilder.toString());
            if (--this.k == 0)
                this.res = stringBuilder.toString();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (this.visited[i - 1] == 1)
                continue;
            this.visited[i - 1] = 1;
            stringBuilder.append(i);
            dfs(stringBuilder, cur + 1, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            this.visited[i - 1] = 0;
        }
    }

    public String getPermutation(int n, int k) {
        if (n <= 0)
            return "";
        if (n == 1)
            return "1";
        if(n == 2)
            return k == 1?"12" : "21";
        this.visited = new int[n];
        int num = 1;
        for (int i = 2; i <= n - 1; i++) {
            num *= i;
        }
        int count = 0;
        while(k - num > 0){
            k -= num;
            count++;
        }
        this.visited[count] = 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(count+1);
        this.k = k;
        dfs(stringBuilder, 1, n);
        return this.res;
    }
}
