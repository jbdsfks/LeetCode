package easy;

import java.util.PriorityQueue;

/**
 * @Description 703. Kth Largest Element in a Stream
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
 * Example:
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * Note:
 * You may assume that nums' length ≥ k-1 and k ≥ 1.
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 * 示例:
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * 说明:
 * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 * @Author lzj
 * @Date 2019/5/8 13:50
 */
public class KthLargestElementInaStream {
    static class KthLargest {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int n : nums)
                add(n);
        }

        /**
         * 思路：
         * 保持一个 k 大小的优先级队列(相当于小顶堆)
         * 当新的数 val 需要 add 时：
         * 如果当前heap.size <= k ，直接入队；
         * 否则，val > heap.peak(当前堆中最小数), 说明 val 加入队列为前K大的，此时移除 heap 中当前最小，将 val 加入；
         * 最后，返回当前 heap 最小，即为第 K 大数
         * @param val
         * @return
         */
        public int add(int val) {
            if (this.heap.size() < this.k) {
                this.heap.offer(val);
            } else if (this.heap.size() > 0 && this.heap.peek() < val) {
                this.heap.poll();
                this.heap.offer(val);
            }
            return this.heap.peek();
        }
    }

}
