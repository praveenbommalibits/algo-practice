package com.algopractice.heap_pq;

import java.util.*;


public class Twitter {

    class Pair {
        int count;
        int tweetId;

        public Pair(int count, int tweetId) {
            this.count = count;
            this.tweetId = tweetId;
        }
    }



    Map<Integer,Pair> userTweetMap;
    Map<Integer, Set<Integer>> followersMap;
    public Twitter() {
        userTweetMap = new HashMap<>();
        followersMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

    }

    public List<Integer> getNewsFeed(int userId) {

    }

    public void follow(int followerId, int followeeId) {
        followersMap.computeIfAbsent(followerId, k->new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

    }


    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.

    }
}
