/*
 * @lc app=leetcode.cn id=846 lang=java
 *
 * [846] 一手顺子
 *
 * https://leetcode-cn.com/problems/hand-of-straights/description/
 *
 * algorithms
 * Medium (41.74%)
 * Likes:    22
 * Dislikes: 0
 * Total Accepted:    1.6K
 * Total Submissions: 3.9K
 * Testcase Example:  '[1,2,3,6,2,3,4,7,8]\n3'
 *
 * 爱丽丝有一手（hand）由整数数组给定的牌。 
 * 
 * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 * 
 * 如果她可以完成分组就返回 true，否则返回 false。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：hand = [1,2,3,6,2,3,4,7,8], W = 3
 * 输出：true
 * 解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 
 * 示例 2：
 * 
 * 输入：hand = [1,2,3,4,5], W = 4
 * 输出：false
 * 解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 * 
 * 
 */
class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length == 0 || hand.length % W != 0)
            return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n : hand)
            map.merge(n, 1, (X, Y) -> (X + 1));
        for (int i = 0; i < hand.length / W; i++) {
            int before_key = map.firstKey();
            if (map.get(before_key) == 1)
                map.remove(before_key);
            else
                map.replace(before_key, map.get(before_key) - 1);
            Integer after_key;
            for (int j = 1; j < W; j++) {
                after_key = map.higherKey(before_key);
                if (after_key == null || after_key != before_key + 1)
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
