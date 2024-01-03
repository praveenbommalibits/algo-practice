package com.algopractice.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals intervals = new MergeIntervals();
        int[][] ans = intervals.merge(new int[][]{

        });

        for (int[] a : ans) {
            System.out.println(a[0]+" "+ a[1]);
        }

    }

    public int[][] merge(int[][] intervals) {

        if(intervals.length == 0) return new int[][]{};
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        List<int[]> ans = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];
        int  i = 1;
        while(i< intervals.length) {
            int s = intervals[i][0];
            int e = intervals[i][1];

            if(s <= end) {
                end = Math.max(end, e);
            } else {
                ans.add(new int[]{start, end});
                start = s;
                end = e;
            }
            i++;
        }

        ans.add(new int[]{start,end});

        int arr[][] = new int[ans.size()][];

        for (int j = 0; j < ans.size(); j++) {
            arr[j] = ans.get(j);
        }

        return   arr;
    }
}
