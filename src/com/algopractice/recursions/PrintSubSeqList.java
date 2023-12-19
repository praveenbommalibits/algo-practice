package com.algopractice.recursions;

import java.util.ArrayList;

public class PrintSubSeqList {
    public static void main(String[] args) {
        PrintSubSeqList subSeqList = new PrintSubSeqList();
        int arr[] = new int[]{1,2,3};
        subSeqList.printSubSeq(arr, new ArrayList<Integer>(), 0);
    }

    private void printSubSeq(int[] arr, ArrayList<Integer> res, int i) {

        if(i == arr.length) {
            for(int a: res)
                System.out.print(a + " ");
            if(res.size()==0)
                System.out.print("{}");
            System.out.println();
            return;
        }

        res.add(arr[i]);
        printSubSeq(arr, res, i+1);
        res.remove(res.size()-1);
        printSubSeq(arr, res, i+1);
    }
}
