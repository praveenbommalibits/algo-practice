package com.algopractice.intervals;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        System.out.println(nonOverlappingIntervals.eraseOverlapIntervals(new int[][]{
                //{0,2},{1,3},{2,4},{3,5},{4,6}
                {1,2},{2,5},{6,55}
        }));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        int ans =0;
        int n = intervals.length;
        if(n==0 || n==1) return ans;
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        int start = intervals[0][0];
        int end  = intervals[0][1];

        int i =1;
        while(i < n) {
            if(intervals[i][0] < end) { 
                ans++;
                if(intervals[i][1] < end) {
                    start = intervals[i][0];
                    end = intervals[i][1];
                }
            } else {
                start = intervals[i][0];
                end = intervals[i][1];
            }
            i++;
        }
        return ans;

    }
}
