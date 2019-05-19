package medium;

import java.util.*;

/**
 * @Description 355. Design Twitter
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * Example:
 * Twitter twitter = new Twitter();
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 * 示例:
 * Twitter twitter = new Twitter();
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 * @Author lzj
 * @Date 2019/5/19 14:30
 */
public class DesignTwitter {
    /**
     * 思路：
     * 定义 count 表示全局发送推文的次序，因为这题不能用 Date 直接表示
     * 定义 followMap 表示 key(userId) 关注了 value(HashSet)
     * 定义 tweetMap 表示 key(userId) 发表了 value(TreeMap)， 其中 value 的 TreeMap 中，key (count), value(tweetId)
     */
    static class Twitter {
        HashMap<Integer, HashSet<Integer>> followMap;
        HashMap<Integer, TreeMap<Integer, Integer>> tweetMap;
        int count;
        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            followMap = new HashMap<>();
            tweetMap = new HashMap<>();
            count = 0;
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            TreeMap<Integer, Integer> tweetTreeSet = tweetMap.getOrDefault(userId, new TreeMap<>());
            tweetTreeSet.put(++count, tweetId);
            tweetMap.put(userId, tweetTreeSet);
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         *
         */
        public List<Integer> getNewsFeed(int userId) {
            HashSet<Integer> followeeSet = followMap.get(userId);  // 用户的关注列表
            List<Integer> resultList = new ArrayList<>();  // 结果集
            TreeMap<Integer, Integer> userAndFolloweeTweet = new TreeMap<>(); // 用户自己和关注的所有人的推文Map，按全局count升序
            if (tweetMap.containsKey(userId))  // 如果当前用户发文， 把他自己的所有推文放入推文Map
                userAndFolloweeTweet.putAll(tweetMap.get(userId));
            if (followeeSet!=null)  // 如果存在关注的人
                for (int user : followeeSet) // 对每个关注的人
                    if (tweetMap.containsKey(user) && tweetMap.get(user).size() > 0) // 如果关注的人发了推文
                        userAndFolloweeTweet.putAll(tweetMap.get(user));  // 将关注人推文放入推文Map
            while (resultList.size() < 10 && userAndFolloweeTweet.size() > 0)  // 返回集 < 0 且 推文Map还有
                resultList.add(userAndFolloweeTweet.pollLastEntry().getValue()); // 将推文Map的最后一个poll出来，并将value放入结果集
            return resultList;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            HashSet<Integer> followeeSet = followMap.getOrDefault(followerId, new HashSet<>());
            followeeSet.add(followeeId);
            followMap.put(followerId, followeeSet);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            if (followMap.containsKey(followerId)) {
                HashSet<Integer> followeeSet = followMap.get(followerId);
                followeeSet.remove(followeeId);
                followMap.put(followerId, followeeSet);
            }
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        twitter.postTweet(1,5);
        twitter.postTweet(1,3);
        twitter.getNewsFeed(1);

    }
}
