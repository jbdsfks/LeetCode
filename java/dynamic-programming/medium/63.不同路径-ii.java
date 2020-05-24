/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 *
 * https://leetcode-cn.com/problems/unique-paths-ii/description/
 *
 * algorithms
 * Medium (31.69%)
 * Likes:    146
 * Dislikes: 0
 * Total Accepted:    17K
 * Total Submissions: 53.6K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 
 * 
 * 
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 
 * 说明：m 和 n 的值均不超过 100。
 * 
 * 示例 1:
 * 
 * 输入:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 
 * 
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] table = new int[n][m];
        for(int i = n - 1;i>=0;i--){
            if(obstacleGrid[i][m-1] != 1)
                table[i][m-1] = 1;
            else
                break;
        }
        for(int i=m-1;i>=0;i--){
            if(obstacleGrid[n-1][i] != 1)
                table[n-1][i] = 1;
            else
                break;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m-2; j >= 0; j--) {
                if(obstacleGrid[i][j] == 1)
                    table[i][j] = 0;
                else{
                    table[i][j] = table[i+1][j] + table[i][j+1];
                }
            }
        }
        return table[0][0];
    }
}

