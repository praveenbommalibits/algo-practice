package com.algopractice.heap_pq;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementArray {
    public static void main(String[] args) {
        KthLargestElementArray elementArray = new KthLargestElementArray();
        System.out.println(elementArray.findKthLargest(new int[]{3,2,1, 5, 6,4}, 2));
        System.out.println(elementArray.findKthLargest1(new int[]{3,2,1, 5, 6,4}, 2));
    }

    private int findKthLargest1(int[] nums, int k) {
        int[] arr = new int[20001];
        for(int num:nums){
            arr[num+10000]++;
        }
        for (int i = 20000; i >=0 ; i--) {
            if(arr[i] > 0){
                if(k==1 || k <= arr[i]) return i-10000;
                k = k-arr[i];
            }
        }
        return 0;
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num:nums) {
           maxHeap.offer(num);
        }
        for (int i = 0; i <k-1 ; i++) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }
}
