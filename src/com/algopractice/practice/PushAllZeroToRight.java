package com.algopractice.practice;

public class PushAllZeroToRight {
    public static void main(String[] args) {
        int arr[] = new int[]{10,0,20,30,0,40,0,50,0,70,60};
        pushAllZeroToRight(arr, arr.length);
    }

    private static void pushAllZeroToRight(int[] arr, int n) {

        int  p = 0,t;
        for (int i = 0; i < n; i++) {
            if(arr[i] != 0) {
                swap(arr, p,i);
                p++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");

        }
    }

    private static void swap(int[] arr, int p, int i) {
        int t = arr[p];
        arr[p] = arr[i];
        arr[i] = t;
    }
}
