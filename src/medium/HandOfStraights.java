package medium;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Description 846. Hand of Straights
 * Alice has a hand of cards, given as an array of integers.
 * Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
 * Return true if and only if she can.
 * Note:
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 * 爱丽丝有一手（hand）由整数数组给定的牌。
 * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 * 如果她可以完成分组就返回 true，否则返回 false。
 * Example 1:
 * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
 * Example 2:
 * Input: hand = [1,2,3,4,5], W = 4
 * Output: false
 * Explanation: Alice's hand can't be rearranged into groups of 4.
 * @Author lzj
 * @Date 2019/5/5 19:37
 */
public class HandOfStraights {
    static class Solution {
        public boolean isNStraightHand(int[] hand, int W) {
            if (hand.length == 0 || hand.length % W != 0)
                return false;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int n : hand)
                map.merge(n, 1, (X, Y) -> (X + 1));
            for (int i = 0; i < hand.length / W; i++) {
                Integer before_key = map.firstKey();
                if (map.get(before_key) == 1)
                    map.remove(before_key);
                else
                    map.replace(before_key, map.get(before_key) - 1);
                Integer after_key;
                for (int j = 1; j < W; j++) {
                    after_key = map.higherKey(before_key);
                    if (after_key == null || after_key!= before_key +1)
                        return false;
                    if (map.get(after_key) == 1)
                        map.remove(after_key);
                    else
                        map.replace(after_key, map.get(after_key) - 1);
                    before_key = after_key;
                }
            }
            return true;
        }
    }

    public static String printIntArray(int[] arr) {
        System.out.print('[');
        for (int n : arr) {
            System.out.print(n + ",");
        }
        System.out.print(']');
        return "";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] hands = {
                {1, 2, 3, 6, 2, 3, 4, 7, 8},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 5, 2, 3, 4, 7, 8},
                {2,1}
        };
        int[] Ws = {3, 4, 3,2};
        boolean[] acs = {true, false, false, true};

        for (int i = 0; i < hands.length; i++) {
            System.out.println(printIntArray(hands[i]) + "\t W = " + Ws[i] + "\t res = " + solution.isNStraightHand(hands[i], Ws[i]) + "\t ac = " + acs[i]);
        }
    }
}
