package medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description 973. K Closest Points to Origin
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 * Note:
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 * @Author lzj
 * @Date 2019/5/24 18:33
 */
public class KClosestPointstoOrigin {
    static class Solution {
        public int[][] kClosest(int[][] points, int K) {
            PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    double dis =  (Math.sqrt(o1[0] * o1[0] + o1[1] * o1[1]) - Math.sqrt(o2[0] * o2[0] + o2[1] * o2[1]));
                    return dis == 0 ? 0 : dis > 0 ? 1 : -1;
                }
            });
            for (int[] point:points)
                minHeap.offer(point);
            int[][] res = new int[K][2];
            for (int i = 0; i<K;i++)
                res[i] = minHeap.poll();
            return res;
        }
    }

    public static void main(String[] args) {
        int[][] test = {
                {3,3},
                {5,-1},
                {-2,4}
        };
        int k = 2;
        Solution solution = new Solution();
        solution.kClosest(test, k);
    }
}
