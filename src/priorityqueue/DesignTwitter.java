package priorityqueue;

import java.util.*;

/**
 * Leetcode 355 https://leetcode.com/problems/design-twitter/
 *
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user,
 * and is able to see the 10 most recent tweets in the user's news feed.
 *
 * Implement the Twitter class:
 *
 *     Twitter() Initializes your twitter object.
 *     void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
 *     List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
 *     void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
 *     void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId
 */

public class DesignTwitter {
    class Pair {
        int f,s;

        Pair(int first, int second) {
            this.f = first;
            this.s = second;
        }
    }

    class User {
        int userId;
        Set<Integer> followers;
        List<Pair> tweets;

        User(int userId) {
            this.userId = userId;
            followers = new HashSet<>(0);
            tweets = new ArrayList<>(0);
        }

        void postTweet(int id, int timestamp) {
            tweets.add(new Pair(id, timestamp));
        }

        void follow(int id) {
            followers.add(id);
        }

        void unfollow(int id) {
            followers.remove(id);
        }

        List<Pair> getTweets() {
            return tweets;
        }

        Set<Integer> getFollowers() {
            return followers;
        }
    }

    Map<Integer, User> users;
    private static int ts;

    public DesignTwitter() {
        users = new HashMap<Integer, User>();
        ts = 0;
    }

    public void postTweet(int userId, int tweetId) {
        User u;
        if (!users.containsKey(userId)) {
            u = new User(userId);
            users.put(userId, u);
        } else {
            u = users.get(userId);
        }
        u.postTweet(tweetId, ts++);
    }

    public List<Integer> getNewsFeed(int userId) {
        // print("Getting news feed");
        if (!users.containsKey(userId)) {
            return Collections.emptyList();
        }
        User u = users.get(userId);
        Set<Integer> followers = u.getFollowers();
        // print("Followers");
        for (int x: followers) {
            System.out.print(x+" ");
        }


        Comparator<Pair> cmp = (final Pair p1, final Pair p2) -> p1.s - p2.s;
        PriorityQueue<Pair> pq = new PriorityQueue<>(10, cmp);
        for (int x: followers) {
            if (!users.containsKey(x)) continue;
            List<Pair> tweets = users.get(x).getTweets();
            for (Pair p: tweets) {
                pq.add(p);
                if (pq.size() > 10) pq.poll();
            }
        }

        List<Pair> tweets = u.getTweets();
        for (Pair p: tweets) {
            pq.add(p);
            if (pq.size() > 10) pq.poll();
        }

        List<Integer> res = new ArrayList<>(0);
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            res.add(p.f);
        }
        Collections.reverse(res);
        return res;
    }

    public void follow(int followerId, int followeeId) {
        User u;
        if (!users.containsKey(followerId)) {
            u = new User(followerId);
            users.put(followerId, u);
        } else {
            u = users.get(followerId);
        }
        u.follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        // Assuming this relationship exist already
        if (!users.containsKey(followerId)) return;
        User u = users.get(followerId);
        u.unfollow(followeeId);
    }

    private void print(String s) {
        System.out.println(s);
    }
}
