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

        public int getCount() {
            return count;
        }


        public int getTweetId() {
            return tweetId;
        }

    }



    int count = 0;
    Map<Integer,Pair> userTweetMap;
    Map<Integer, Set<Integer>> followersMap;
    Comparator<Pair> pairComparator = Comparator.comparingInt(Pair::getCount).reversed();
    PriorityQueue<Pair> maxHeap = new PriorityQueue<>(pairComparator);
    public Twitter() {
        userTweetMap = new HashMap<>();
        followersMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userTweetMap.put(userId, new Pair(count, tweetId));
        count++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new LinkedList<>();

        followersMap.computeIfAbsent(userId, k->new HashSet<>()).add(userId);

        for(Integer followee : followersMap.get(userId)){
            if(userTweetMap.containsKey(followee)) {
                Pair p = userTweetMap.get(followee);
                maxHeap.add(p);
            }
        }

        while(!maxHeap.isEmpty() && ans.size() < 10){
            ans.add(maxHeap.poll().tweetId);
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        followersMap.computeIfAbsent(followerId, k->new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        followersMap.get(followerId).remove(followeeId);
    }


    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        List<Integer> list = twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        printAns(list);
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        list = twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        printAns(list);
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        list = twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
        printAns(list);


    }

    private static void printAns(List<Integer> list) {
        for(Integer a : list) {
            System.out.print(a+" ");
        }
        System.out.println();
    }
}
