package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Description 378. Kth Smallest Element in a Sorted Matrix
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * Example:
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n^2.
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 * 示例:
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * return 13。
 * @Author lzj
 * @Date 2019/5/20 16:25
 */
public class KthSmallestElementInASortedMatrix {
    static class Solution {
        /**
         * 暴力解法也能过？？？？
         * @param matrix
         * @param k
         * @return
         */
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int[] temp = new int[n*n];
            int index = 0;
            for (int i = 0; i< n;i++)
                for (int j = 0;j<n;j++)
                    temp[index++] = matrix[i][j];
            Arrays.sort(temp);
            return temp[k-1];
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,3,5},
                {6,7,12},
                {11,14,14}
        };
        int k = 5;
        Solution solution = new Solution();
        solution.kthSmallest(matrix, k);
    }
}
