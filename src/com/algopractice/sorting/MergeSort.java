package com.algopractice.sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,6,2,5,7,9,1,3};
        mergesort(arr, 0, arr.length-1);
        for(int ele : arr) {
            System.out.print(" "+ele);
        }
    }

    private static void mergesort(int[] arr, int low, int high) {
        if(low == high )
            return;

        int mid= (low+high)/2;
        mergesort(arr, low, mid);
        mergesort(arr, mid+1, high);
        mergefn(arr, low, mid, high);

    }

    private static void mergefn(int[] arr, int low, int mid, int high) {

        int i =low, j=mid+1, k=0;
        int n = high-low+1;
        int temp[] = new int[n];

        while(i<= mid && j <= high) {
            if(arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i <=mid) {
            temp[k] = arr[i];
            i++;k++;
        }

        while(j<=high) {
            temp[k] = arr[j];
            j++;k++;
        }
        for (int l = 0; l <n; l++) {
            arr[low+l] = temp[l];
        }

    }

}
