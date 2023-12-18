package com.algopractice.binarysearch;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2,1}));
    }

    public static int findMin(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums[0];

        int l =0, h=nums.length-1;
        int ans = nums[0];

        while(l <= h) {
            if(nums[l] < nums[h]) {
                ans = Math.min(ans, nums[l]);
                break;
            }
            int mid = (l+h)/2;
            ans = Math.min(ans, nums[mid]);
            if(nums[mid] >= nums[l])
                l = mid+1;
            else
                h = mid-1;
        }

        return ans;

    }
}
