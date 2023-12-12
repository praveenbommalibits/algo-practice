package com.algopractice.arrays_hashing;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));

        System.out.println(containsDuplicate1(new int[]{1, 2, 3, 1}));
    }

    private static boolean containsDuplicate1(int[] nums) {

        for(int i =0; i< nums.length; i++) {
            int cur = nums[i];
            int j = i-1;
            while( j >= 0 && cur < nums[j]) {
                nums[j+1] = nums[j];
                j--;
            }
            if(j >=0 && cur == nums[j]) {
                return true;
            }
            nums[j+1] = cur;
        }

        return false;
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer>  uniqueSet = new HashSet<>();
        for(int i=0; i< nums.length ; i++) {
            if(uniqueSet.contains(nums[i])){
                return true;
            } else uniqueSet.add(nums[i]);
        }

        return false;
    }
}
