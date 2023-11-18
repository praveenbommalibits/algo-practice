package com.algopractice.practice;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestLargest {
    public static void main(String[] args) {
        /**
         * Approaches
         * 1. Arrays sort  and get the kth element
         * 2, Using MaxHeap to offer values and poll the max element matching with k
         */

        int[] arr = new int[] { 10, 5, 4, 3, 48, 6, 2, 33, 53, 10 };
        System.out.println(findKthSmallestNo(arr, 4));
        System.out.println(findKthSmallestNoA1(arr, 4));
        System.out.println(findKthLargestNoA1(arr,4));
    }

    private static Integer findKthLargestNoA1(int[] arr, int k) {

        //default condition

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int ele: arr) {
            pq.offer(ele);
        }

        for (int i = 0; i < k; i++) {
            pq.poll();
        }
        return pq.peek();


    }

    private static int findKthSmallestNoA1(int[] arr, int k) {
        if(arr == null || arr.length ==0 || k <0 || k > arr.length)
            return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int ele: arr) {
            pq.offer(ele);
        }
        for(int i=0; i < k-1; i++)
            pq.poll();

        return pq.peek();
    }

    private static int findKthSmallestNo(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k < 0|| k> arr.length)
            return -1;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

        for (int ele: arr) {
            maxHeap.offer(ele);

            if(maxHeap.size() > k)
                maxHeap.poll();
        }
        return maxHeap.peek();
    }
}
