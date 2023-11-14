package com.algopractice.problemsolving;


import java.util.Arrays;

/**
 * Sort the array of 0s 1s and 2s in sorted order
 */
public class SortArray0s1s2s {
    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0,1,2,1,2,0,0,0,1};
        int arr_size = arr.length;
        sortApproach01(arr, arr_size);
        System.out.println("Approach 2");

        sortApproach02(arr, arr_size);


    }

    private static void sortApproach02(int[] arr, int arr_size) {
        int l =0;
        int h = arr_size-1;
        int mid = 0, temp =0;
        while(mid <= h) {
            switch (arr[mid]){
                case 0:
                    temp = arr[l];
                    arr[l] = arr[mid];
                    arr[mid] = temp;
                    l++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = arr[mid];
                    arr[mid] = arr[h];
                    arr[h] = temp;
                    h--;
                    break;
            }
        }

        System.out.println("\n-------");
        for(int j=0; j<arr_size; j++){
            System.out.print(arr[j] +" ");
        }
    }

    private static void sortApproach01(int[] arr, int arr_size) {
        int cnt0=0, cnt1 = 0, cnt2=0;
        for(int i=0; i< arr_size; i++) {
            switch (arr[i]) {
                case 0:
                    cnt0++;
                    break;
                case 1:
                    cnt1++;
                    break;
                case 2:
                    cnt2++;
                    break;
            }
        }
        System.out.println(cnt0 + " "+ cnt1 +" "+ cnt2);
        int i=0;
        while(cnt0 > 0) {
            arr[i++] =0;
            cnt0--;
        }
        while(cnt1 > 0) {
            arr[i++] =1;
            cnt1--;
        }
        while(cnt2 > 0) {
            arr[i++] =2;
            cnt2--;
        }

        System.out.println("-------");
        for(int j=0; j<arr_size; j++){
            System.out.print(arr[j] +" ");
        }

    }
}
