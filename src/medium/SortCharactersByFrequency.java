package medium;

import java.util.*;

/**
 * @Description 451. Sort Characters By Frequency
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * Example 1:
 * Input:
 * "tree"
 * Output:
 * "eert"
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * Input:
 * "cccaaa"
 * Output:
 * "cccaaa"
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 * Input:
 * "Aabb"
 * Output:
 * "bbAa"
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * 示例 1:
 * 输入:
 * "tree"
 * 输出:
 * "eert"
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * 输入:
 * "cccaaa"
 * 输出:
 * "cccaaa"
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 * 输入:
 * "Aabb"
 * 输出:
 * "bbAa"
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * @Author lzj
 * @Date 2019/5/21 19:50
 */
public class SortCharactersByFrequency {
    static class Solution {
        class Tuple implements Comparable<Tuple>{
            int val;
            char key;

            Tuple(char key, int val){
                this.key = key;
                this.val = val;
            }
            @Override
            public int compareTo(Tuple o) {
                return this.val - o.val;
            }
        }

        /**
         * map 计算每个字符的出现次数；
         * 构造 Tuple 类，实现一个比较器，
         * 将 map 中的元素变成一个 Tuple 数组，使用 Arrays.sort(T) 升序
         * 逆向构造字符串
         * @param s
         * @return
         */
        public String frequencySort(String s) {
            if (s == null || s.equals(""))
                return "";
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray())
                map.put(c, map.getOrDefault(c, 0)+1);
            Tuple[] tuples = new Tuple[map.size()];
            int index = 0;
            for (Map.Entry entry : map.entrySet())
                tuples[index++] = new Tuple((char)entry.getKey(), (int)entry.getValue());
            Arrays.sort(tuples);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = tuples.length - 1; i >= 0 ; i--)
                for (int j = 0; j < tuples[i].val; j++)
                    stringBuilder.append(tuples[i].key);
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        String string = "tree";
        Solution solution = new Solution();
        solution.frequencySort(string);
    }
}
