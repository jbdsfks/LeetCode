package medium;

import java.util.*;

/**
 * @Description 692. Top K Frequent Words
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 * @Author lzj
 * @Date 2019/5/23 18:57
 */
public class TopKFrequentWords {
    static class Solution {
        class Tuple implements Comparable<Tuple>{
            String key;
            Integer val;
            /**
             *
             * @param key 单词
             * @param val 单词出现次数
             */
            Tuple(String key, Integer val){
                this.key = key;
                this.val = val;
            }

            /**
             * 一个比较器，因为词频高在前，同频按字母序，
             * 意味着，当val不相等时，按大顶堆排序
             * 而当val相等时，按小顶堆
             * @param o 比较对象
             * @return this == o ? 0 : (this > o ? 1:-1);
             */
            @Override
            public int compareTo(Tuple o) {
                if (!o.val.equals(this.val))
                    return o.val - this.val;
                else
                    return this.key.compareTo(o.key);
            }
        }
        public List<String> topKFrequent(String[] words, int k) {
            List<String> res = new ArrayList<>();
            // map计数词频
            HashMap<String, Integer> map = new HashMap<>();
            for (String s:words)
                map.put(s, map.getOrDefault(s, 0) + 1);
            // 不同频时，词频大顶堆；同频时，字母序小顶堆
            PriorityQueue<Tuple> maxHeap = new PriorityQueue<>();
            for (Map.Entry<String, Integer> entry:map.entrySet())
                maxHeap.offer(new Tuple(entry.getKey(), entry.getValue()));
            while (k-- > 0 && maxHeap.size() > 0)
                res.add(maxHeap.poll().key);
            return res;
        }
    }
}
