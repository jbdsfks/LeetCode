package easy;

/**
 * @Description 38. Count and Say
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 * Example 2:
 *
 * Input: 4
 * Output: "1211"
 * @Author lzj
 * @Date 2019/5/25 19:41
 */
public class CountAndSay {
    static class Solution {
        public String countAndSay(int n) {
            if (n == 1)
                return "1";
            String res = "1";
            /*
             * n >= 2
             * 从 "1" 开始，转成chars，然后统计同一个char的出现次数 count ，统计过后，append
             */
            for (int i = 1; i<n;i++){
                // 默认至少一次
                int count = 1;
                // 转换成chars
                char[] chars = res.toCharArray();
                // 比对ch， 初始化默认取第一个char
                char ch = chars[0];
                StringBuilder stringBuilder = new StringBuilder();
                // 从第二个char开始
                for (int j = 1; j < chars.length; j++){
                    // 相等，则计数器++
                    if (chars[j] == ch){
                        count++;
                    }else {
                        // 不相等，append
                        stringBuilder.append(count); // count为多少，代表出现了几次ch，因此append(count)
                        stringBuilder.append(ch);
                        ch = chars[j];  // 修改比对ch
                        count = 1;   // 恢复为一次
                    }
                }
                // 用于append最后一个ch出现的次数。
                stringBuilder.append(count);
                stringBuilder.append(ch);
                res = stringBuilder.toString();
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.countAndSay(8);

    }
}
