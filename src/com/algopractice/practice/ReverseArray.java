package com.algopractice.practice;

public class ReverseArray {
    public static void main(String[] args) {
        int[] list =  new int[]{12, 13, 14, 15, 16};
        //reverseArray(list, list.length);
        recursiveWay(list, 0, list.length-1);
        printArrays(list, list.length);
    }

    private static void printArrays(int[] list, int n) {

        for (int i = 0; i < n; i++) {
            System.out.print(list[i] + " ");
        }
    }

    private static void recursiveWay(int[] arr, int s, int e) {
        int t;
        if(s >= e)
            return;
         t = arr[s];
        arr[s] = arr[e];
        arr[e] = t;
        recursiveWay(arr, s+1, e-1);
    }

    private static void reverseArray(int[] list, int n) {

        int temp;
        for (int i = 0; i < n/2; i++) {
            temp = list[i];
            list[i] = list[n-i-1];
            list[n-i-1] = temp;
        }

    }
}
