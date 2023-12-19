package com.algopractice.recursions;

public class PrintSubSeqSumKCount {
    public static void main(String[] args) {
        PrintSubSeqSumKCount kCount = new PrintSubSeqSumKCount();
        int k=2;
        System.out.println(kCount.printSubSeqCount(new int[]{1,2,1}, k,0,0));
    }

    private int printSubSeqCount(int[] arr, int k , int sum, int i) {

        if(i==arr.length) {
            if(k==sum) return 1;
            return 0;
        }
        sum += arr[i];
        int l = printSubSeqCount(arr, k, sum,i+1);
        sum -= arr[i];
        int r = printSubSeqCount(arr, k, sum,i+1);

        return l+r;
    }


}
