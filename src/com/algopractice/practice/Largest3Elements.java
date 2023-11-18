package com.algopractice.practice;

public class Largest3Elements {
    public static void main(String[] args) {
        int arr[] = new int[] {10,20,60, 4, 60,100, 18};
        System.out.println(findLargestKNos(arr, arr.length, 3));
    }

    private static String findLargestKNos(int[] arr, int n, int k) {

        if(arr == null || n < 3 || k < 0) {
            return "invalid";
        }
        int f = Integer.MIN_VALUE, s=Integer.MIN_VALUE, t = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            if(arr[i] > f) {
                t = s;
                s = f;
                f = arr[i];
            } else if (arr[i] > s && arr[i] !=f) {
                t = s;
                s = arr[i];
            } else if (arr[i] > t && arr[i] !=s) {
                t = arr[i];
            }

        }

        return f + ""+s+""+t;
    }
}
