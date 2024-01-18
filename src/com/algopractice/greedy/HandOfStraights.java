package com.algopractice.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HandOfStraights {
    public static void main(String[] args) {
        HandOfStraights handOfStraights = new HandOfStraights();




        System.out.println(handOfStraights.isNStraightHand(new int[]{2,1}, 2));
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n==1) return true;

        if(n % groupSize != 0) return false;



        Map<Integer, Integer> countMap = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int h: hand) {
            if(!countMap.containsKey(h)) {
                countMap.put(h, 1);
            } else {
                countMap.put(h, countMap.get(h)+1);
            }
        }

        minHeap.addAll(countMap.keySet());
        while(!minHeap.isEmpty()) {

            int first  = minHeap.peek(); 
            for (int i = first; i < first+groupSize; i++) {
                if(!countMap.containsKey(i)) return false;
                countMap.put(i, countMap.get(i)-1);
                if (countMap.get(i) == 0) {
                    if(i != minHeap.peek()) return false;
                    minHeap.poll();
                }

            }

        }
        return true;

    }
}
