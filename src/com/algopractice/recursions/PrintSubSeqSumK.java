package com.algopractice.recursions;

import java.util.ArrayList;
import java.util.List;

public class PrintSubSeqSumK {
    public static void main(String[] args) {
        PrintSubSeqSumK subSeqSum = new PrintSubSeqSumK();
        int arr[] = new int[]{1,2,1};
        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        subSeqSum.printSubSeq(0,arr,arr.length, ans, sum);
    }

    private void printSubSeq(int i, int[] arr, int n, List<Integer> ans, int sum) {
        //Base case
        if(i==n) {
            if(sum == 2) {
                for (int a :ans) {
                    System.out.print(a +" ");
                }
                System.out.println();
            }
            return;
        }

        ans.add(arr[i]);
        sum = sum+arr[i];

        printSubSeq(i+1,arr, n,ans,sum);

        sum = sum-arr[i];
        ans.remove(ans.size()-1);

        printSubSeq(i+1, arr, n, ans, sum);

    }
}
