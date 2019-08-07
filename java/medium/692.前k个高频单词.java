/*
 * @lc app=leetcode.cn id=692 lang=java
 *
 * [692] 前K个高频单词
 *
 * https://leetcode-cn.com/problems/top-k-frequent-words/description/
 *
 * algorithms
 * Medium (39.31%)
 * Likes:    36
 * Dislikes: 0
 * Total Accepted:    1.9K
 * Total Submissions: 4.8K
 * Testcase Example:  '["i", "love", "leetcode", "i", "love", "coding"]\n2'
 *
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * 
 * 示例 1：
 * 
 * 
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * ⁠   注意，按字母顺序 "i" 在 "love" 之前。
 * 
 * 
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"],
 * k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * ⁠   出现次数依次为 4, 3, 2 和 1 次。
 * 
 * 
 * 
 * 
 * 注意：
 * 
 * 
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 * 
 * 
 * 
 * 
 * 扩展练习：
 * 
 * 
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 * 
 * 
 */
class Solution {
    class Tuple implements Comparable<Tuple> {
        String key;
        Integer val;

        /**
         *
         * @param key 单词
         * @param val 单词出现次数
         */
        Tuple(String key, Integer val) {
            this.key = key;
            this.val = val;
        }

        /**
         * 一个比较器，因为词频高在前，同频按字母序， 意味着，当val不相等时，按大顶堆排序 而当val相等时，按小顶堆
         * 
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
        for (String s : words)
            map.put(s, map.getOrDefault(s, 0) + 1);
        // 不同频时，词频大顶堆；同频时，字母序小顶堆
        PriorityQueue<Tuple> maxHeap = new PriorityQueue<>();
        for (Map.Entry<String, Integer> entry : map.entrySet())
            maxHeap.offer(new Tuple(entry.getKey(), entry.getValue()));
        while (k-- > 0 && maxHeap.size() > 0)
            res.add(maxHeap.poll().key);
        return res;
    }
}
