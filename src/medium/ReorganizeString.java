package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author lzj
 * @Date 2019/5/23 20:04
 */
public class ReorganizeString {
    static class Solution {
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
            for (Map.Entry<Character, Integer> entry: map.entrySet())
                maxHeap.offer(new Tuple(entry.getKey(), entry.getValue()));
            if (maxHeap.size() == 1)
                return "";
            //如果最大频率大于一半+1，则无法完成任务
            if (maxHeap.peek().val > (1 + S.length()) / 2)
                return "";
            while (maxHeap.size() > 1){
                Tuple tuple1 = maxHeap.poll();
                Tuple tuple2 = maxHeap.poll();
                int count = tuple1.val;
                if (! tuple1.val.equals(tuple2.val)){
                    count  = tuple2.val;
                    tuple1.val = tuple1.val - count;
                    maxHeap.offer(tuple1);
                }
                while (count-->0){
                    stringBuilder.append(tuple1.key);
                    stringBuilder.append(tuple2.key);
                }
            }
            if (maxHeap.size() > 0){
                Tuple tuple = maxHeap.poll();
                if (tuple.val > 1)
                    return "";
                else {
                    stringBuilder.append(tuple.key);
                    return stringBuilder.toString();
                }
            }
            else
                return stringBuilder.toString();
        }
    }
}
