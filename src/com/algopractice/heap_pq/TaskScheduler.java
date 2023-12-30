package com.algopractice.heap_pq;

import java.util.*;

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
        while(!maxHeap.isEmpty()) {
            totalTime += 1;
            int remainTaskCount = maxHeap.poll()-1;
            if(remainTaskCount >0) {
                trackQueue.add(new int[]{remainTaskCount, totalTime+n});
            }

            if(!trackQueue.isEmpty() && trackQueue.peek()[1]==totalTime) {
                maxHeap.add(trackQueue.poll()[0]);
            }
        }
        return totalTime;
    }
}
