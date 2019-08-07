/*
 * @lc app=leetcode.cn id=355 lang=java
 *
 * [355] 设计推特
 *
 * https://leetcode-cn.com/problems/design-twitter/description/
 *
 * algorithms
 * Medium (32.88%)
 * Likes:    22
 * Dislikes: 0
 * Total Accepted:    744
 * Total Submissions: 2.3K
 * Testcase Example:  '["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"]\n[[],[1,5],[1],[1,2],[2,6],[1],[1,2],[1]]'
 *
 * 
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 * 
 * 
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId):
 * 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 * 
 * 
 * 示例:
 * 
 * 
 * Twitter twitter = new Twitter();
 * 
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 * 
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 * 
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 * 
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 * 
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 * 
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 * 
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 * 
 * 
 */
class Twitter {
    HashMap<Integer, HashSet<Integer>> followMap;
    HashMap<Integer, TreeMap<Integer, Integer>> tweetMap;
    int count = 0;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
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
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
     * the news feed must be posted by users who the user followed or by the user
     * herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        HashSet<Integer> followeeSet = followMap.get(userId);
        List<Integer> resultList = new ArrayList<>();
        TreeMap<Integer, Integer> userAndFolloweeTweet = new TreeMap<>();
        if (tweetMap.containsKey(userId))
            userAndFolloweeTweet.putAll(tweetMap.get(userId));
        if (followeeSet != null)
            for (int user : followeeSet)
                if (tweetMap.containsKey(user) && tweetMap.get(user).size() > 0)
                    userAndFolloweeTweet.putAll(tweetMap.get(user));
        while (resultList.size() < 10 && userAndFolloweeTweet.size() > 0)
            resultList.add(userAndFolloweeTweet.pollLastEntry().getValue());
        return resultList;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> followeeSet = followMap.getOrDefault(followerId, new HashSet<>());
        followeeSet.add(followeeId);
        followMap.put(followerId, followeeSet);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a
     * no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            HashSet<Integer> followeeSet = followMap.get(followerId);
            followeeSet.remove(followeeId);
            followMap.put(followerId, followeeSet);
        }
    }
}
