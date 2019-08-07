/*
 * @lc app=leetcode.cn id=767 lang=java
 *
 * [767] 重构字符串
 *
 * https://leetcode-cn.com/problems/reorganize-string/description/
 *
 * algorithms
 * Medium (32.62%)
 * Likes:    27
 * Dislikes: 0
 * Total Accepted:    1.2K
 * Total Submissions: 3.6K
 * Testcase Example:  '"aab"'
 *
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * 
 * 示例 1:
 * 
 * 
 * 输入: S = "aab"
 * 输出: "aba"
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: S = "aaab"
 * 输出: ""
 * 
 * 
 * 注意:
 * 
 * 
 * S 只包含小写字母并且长度在[1, 500]区间内。
 * 
 * 
 */
class Solution {
    class Tuple implements Comparable<Tuple> {
        Character key;
        Integer val;

        Tuple(Character key, Integer val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple o) {
            return o.val - this.val;
        }
    }

    public String reorganizeString(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Tuple> maxHeap = new PriorityQueue<>();
        for (char c : S.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        for (Map.Entry<Character, Integer> entry : map.entrySet())
            maxHeap.offer(new Tuple(entry.getKey(), entry.getValue()));
        if (maxHeap.size() == 1)
            return "";
        if (maxHeap.peek().val > (1 + S.length()) / 2)
            return "";
        while (maxHeap.size() > 1) {
            Tuple tuple1 = maxHeap.poll();
            Tuple tuple2 = maxHeap.poll();
            int count = tuple1.val;
            if (!tuple1.val.equals(tuple2.val)) {
                count = tuple2.val;
                tuple1.val = tuple1.val - count;
                maxHeap.offer(tuple1);
            }
            while (count-- > 0) {
                stringBuilder.append(tuple1.key);
                stringBuilder.append(tuple2.key);
            }
        }
        if (maxHeap.size() > 0) {
            Tuple tuple = maxHeap.poll();
            if (tuple.val > 1)
                return "";
            else {
                stringBuilder.append(tuple.key);
                return stringBuilder.toString();
            }
        } else
            return stringBuilder.toString();
    }
}
