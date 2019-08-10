import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 *
 * https://leetcode-cn.com/problems/unique-paths/description/
 *
 * algorithms
 * Medium (55.24%)
 * Likes:    289
 * Dislikes: 0
 * Total Accepted:    30.8K
 * Total Submissions: 55.8K
 * Testcase Example:  '3\n2'
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 
 * 问总共有多少条不同的路径？
 * 
 * 
 * 
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * 
 * 说明：m 和 n 的值均不超过 100。
 * 
 * 示例 1:
 * 
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 
 * 
 * 示例 2:
 * 
 * 输入: m = 7, n = 3
 * 输出: 28
 * 
 */
class Solution {

    public int uniquePaths(int m, int n){
        int[] table = new int[n];
        Arrays.fill(table, 1);
        for(int j=1;j<m;j++){
            table[n-1] = 1;
            for(int i=n-2;i>=0;i--){
                table[i] = table[i] + table[i+1];
            }
        }
        return table[0];
    }
    // /**
    //  * √ Accepted 
    //  * √ 62/62 cases passed (1 ms) 
    //  * √ Your runtime beats 97.04 % of java submissions 
    //  * √ Your memory usage beats 13.42 % of java submissions (34.2 MB)
    //  * @param m
    //  * @param n
    //  * @return
    //  */
    // public int uniquePaths(int m, int n) {
    //     int table[][] = new int[n][m];
    //     for (int j = 0; j < m; j++) {
    //         table[n - 1][j] = 1;
    //     }
    //     for (int i = 0; i < n; i++) {
    //         table[i][m - 1] = 1;
    //     }
    //     for (int i = n - 2; i >= 0; i--) {
    //         for (int j = m - 2; j >= 0; j--) {
    //             table[i][j] = table[i + 1][j] + table[i][j + 1];
    //         }
    //     }
    //     return table[0][0];
    // }
}
