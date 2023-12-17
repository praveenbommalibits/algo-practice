package com.algopractice.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,6,2,5,7,9,1,3};
        quickSort(arr, 0, arr.length-1);
        for(int ele : arr) {
            System.out.print(" "+ele);
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pivot =  partitions(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);

        }
    }

    private static int partitions(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low, j=high;
        while(i<j){

            while(arr[i] <= pivot && i <= high-1) i++;

            while(arr[j] > pivot && j >= low+1 ) j--;

            if(i<j)
                swapele(arr, i,j);
        }
        swapele(arr, low, j);
        return j;
    }

    private static void swapele(int[] arr , int a, int b ) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b]=temp;
    }
}
