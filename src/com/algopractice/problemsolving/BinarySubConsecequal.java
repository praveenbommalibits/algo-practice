package com.algopractice.problemsolving;

public class BinarySubConsecequal {
    public static void main(String[] args) {
        String binaryStr = "01001101011100100011";
        int n  = binaryStr.length();
        System.out.println("Total no of MaxSubStringEqual no of 0 and 1s : " +maxSubStr(binaryStr,n));
    }

    private static int maxSubStr(String binaryStr, int n) {
        int count0 = 0, count1 =0;
        int totalCount = 0;
        for(int i=0; i<n; i++){
            if(binaryStr.charAt(i) == '0')
                count0++;
            else
                count1++;
            if(count0==count1)
                totalCount++;

        }
        if(count0 != count1)
            return -1;
        return totalCount;
    }
}
