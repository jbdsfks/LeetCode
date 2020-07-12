package idea.leetcode.editor.cn;

//给定一个 n × n 的二维矩阵表示一个图像。 
//
// 将图像顺时针旋转 90 度。 
//
// 说明： 
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组 
// 👍 485 👎 0


public class RotateImage {
    Solution solution = new Solution();

    public void test() {

    }

    public static void main(String[] args) {
        RotateImage mainClass = new RotateImage();
        mainClass.test();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getAndPutValue(int[][] matrix, int row, int col, int value) {
            int temp = matrix[row][col];
            matrix[row][col] = value;
            return temp;
        }
        public void rotateHelp(int[][] matrix, int start, int end, int n) {
            if (n <= 1)
                return;
            for (int i = 0; i < n - 1; i++){
                int temp = matrix[start][start + i];
                temp = getAndPutValue(matrix, start + i, end, temp);
                temp = getAndPutValue(matrix, end, end - i, temp);
                temp = getAndPutValue(matrix, end - i, start, temp);
                getAndPutValue(matrix, start, start + i, temp);
            }
            rotateHelp(matrix, start + 1, end - 1, n - 2);
        }
        public void rotate(int[][] matrix) {
            rotateHelp(matrix, 0, matrix.length - 1, matrix.length);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}