package com.algopractice.slidingwindow;

import java.util.HashMap;

public class ContainsDuplicate2 {
    public static void main(String[] args) {
        //System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1}, 1));

        System.out.println(containsNearbyDuplicate1(new int[]{1,0,1,1}, 1));
    }

    private static boolean containsNearbyDuplicate1(int[] nums, int k) {
        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(valueIndexMap.containsKey(nums[i])) {
                if(Math.abs(valueIndexMap.get(nums[i])-i) <= k){
                    return true;
                }
            }
            valueIndexMap.put(nums[i],i);

        }
        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;

        for (int i = 0, j = i + k;i < n && j < n && i<j; i++, j--) {
            if(i!=j && nums[i]==nums[j])
                return true;
        }
        return false;
    }
}
