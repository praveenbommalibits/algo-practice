package com.algopractice.arrays_hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(twoSumUnSorted(new int[]{3,2,4}, 6)));
    }

    private static int[] twoSumUnSorted(int[] nums, int target) {

        Map<Integer, Integer> comMap = new HashMap<>();
        for(int i=0; i< nums.length; i++) {
            int cnum = nums[i];
            int dnum = target-cnum;
            if(comMap.containsKey(dnum) && comMap.get(dnum) != i) {
                return new int[] { comMap.get(dnum), i};
            }
            comMap.put(cnum,i);
        }

        return null;
    }

    public static int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];

        int i = 0, j = nums.length-1;
        while(i < j) {
            int sum  = nums[i]+nums[j];
            if(sum == target) {
                ans[0] = i;
                ans[1] = j;
                break;
            } else if (i<j && sum > target) {
                j--;
            } else if (i<j && sum  < target) {
                i++;
            }
        }
        return ans;
    }
}
