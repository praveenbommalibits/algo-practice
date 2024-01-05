package com.algopractice.greedy;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        MaximumSubarraySum maximumSubarraySum = new MaximumSubarraySum();
        System.out.println(maximumSubarraySum.maxSubArray(new int[]{5,4,-1, 7, 8}));
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int sum  = 0 , max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum  += nums[i];

            max = Math.max(sum, max);

            if(sum < 0) {
                sum =0;
            }
        }

        return max;
    }
}
