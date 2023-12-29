package com.algopractice.heap_pq;

import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> minHeap ;
    int k ;
    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.k = k;
        for(int num: nums){
            minHeap.add(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

    }

    private Integer add(int val) {
        minHeap.add(val);
        if(minHeap.size() > k ){
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest =  new KthLargest(3, new int[]{4,5,8,2});
        System.out.println(kthLargest.add(3));
    }


}
