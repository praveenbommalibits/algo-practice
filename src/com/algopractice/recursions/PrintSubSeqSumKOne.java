package com.algopractice.recursions;

import java.util.ArrayList;
import java.util.List;

public class PrintSubSeqSumKOne {
    public static void main(String[] args) {
        PrintSubSeqSumKOne subSeqSum = new PrintSubSeqSumKOne();
        int arr[] = new int[]{1,2,1};
        int sum = 2;
        List<Integer> ans = new ArrayList<>();
        subSeqSum.printSubSeq(arr, sum, ans, 0,0, arr.length);
    }

    private boolean printSubSeq(int[] arr, int sum, List<Integer> ans, int i,int s,  int n) {
        if(i==n) {
            if(sum==s){
                for(int a: ans)
                    System.out.print(a+" ");
                return true;
            }
            return false;
        }

        ans.add(arr[i]);
        s += arr[i];
        if(printSubSeq(arr, sum, ans, i+1, s, n) == true) return true;

        s -= arr[i];
        ans.remove(ans.size()-1);
        if(printSubSeq(arr, sum, ans, i+1, s, n) == true) return true;

        return false;
    }
}
