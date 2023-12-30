package com.algopractice.heap_pq;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        System.out.println(lastStoneWeight.lastStoneWeight(new int[]{2, 7, 4, 1,8,1}));
    }

    public int lastStoneWeight(int[] stones) {

        for(int stone: stones){
            maxHeap.add(stone);
        }
        while(maxHeap.size() > 1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if(x != y) {
                y = Math.abs(x-y);
                maxHeap.add(y);
            }
        }
        return (maxHeap.size()==1)? maxHeap.peek():0;
    }
}
