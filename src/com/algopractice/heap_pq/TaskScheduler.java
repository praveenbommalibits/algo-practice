package com.algopractice.heap_pq;

import java.util.*;

/**
 *
 1. Valid Parentheses: https://lnkd.in/gjfmc-sR

 2. Merge Intervals: https://lnkd.in/gPMQWcKV

 3. Best Time to Buy and Sell Stock: https://lnkd.in/gzyaCJeD

 4. Combination Sum: https://lnkd.in/g8G7Ad69

 5. Number of Islands: https://lnkd.in/gPhFiieJ

 6. Group Anagrams: https://lnkd.in/gxUFWtaE

 7. LRU Cache: https://lnkd.in/gG2CNNfN

 8. Longest Substring Without Repeating Characters: https://lnkd.in/gAMzN3jV

 9. Basic Calculator: https://lnkd.in/gXZQzQnK

 10. Two Sum: https://lnkd.in/g9Vidkj4

 */
public class TaskScheduler {
    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        System.out.println(taskScheduler.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }


    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> cCount = new HashMap<>();
        for(char task: tasks) {
            cCount.put(task, cCount.getOrDefault(task,0)+1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.addAll(cCount.values());
        Queue<int[]> trackQueue = new LinkedList<>();
        int totalTime = 0;
        while(!maxHeap.isEmpty() ||
                !trackQueue.isEmpty()) {
            totalTime += 1;
            if(!maxHeap.isEmpty()) {
                int remainTaskCount = maxHeap.poll() - 1;
                if (remainTaskCount > 0) {
                    trackQueue.add(new int[]{remainTaskCount, totalTime + n});
                }
            }

            if(!trackQueue.isEmpty() && trackQueue.peek()[1]==totalTime) {
                maxHeap.add(trackQueue.poll()[0]);
            }
        }
        return totalTime;
    }
}
