/*
 * @lc app=leetcode.cn id=451 lang=java
 *
 * [451] 根据字符出现频率排序
 *
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/description/
 *
 * algorithms
 * Medium (58.14%)
 * Likes:    51
 * Dislikes: 0
 * Total Accepted:    4.7K
 * Total Submissions: 8.1K
 * Testcase Example:  '"tree"'
 *
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * 
 * 示例 1:
 * 
 * 
 * 输入:
 * "tree"
 * 
 * 输出:
 * "eert"
 * 
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入:
 * "cccaaa"
 * 
 * 输出:
 * "cccaaa"
 * 
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入:
 * "Aabb"
 * 
 * 输出:
 * "bbAa"
 * 
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * 
 * 
 */
class Solution {
    class Tuple implements Comparable<Tuple> {
        int val;
        char key;

        Tuple(char key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.val - o.val;
        }
    }

    public String frequencySort(String s) {
        if (s == null || s.equals(""))
            return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        Tuple[] tuples = new Tuple[map.size()];
        int index = 0;
        for (Map.Entry entry : map.entrySet())
            tuples[index++] = new Tuple((char) entry.getKey(), (int) entry.getValue());
        Arrays.sort(tuples);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = tuples.length - 1; i >= 0; i--)
            for (int j = 0; j < tuples[i].val; j++)
                stringBuilder.append(tuples[i].key);
        return stringBuilder.toString();
    }
}
