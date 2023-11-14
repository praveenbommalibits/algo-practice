package com.algopractice.problemsolving;

import java.util.Arrays;
import java.util.stream.Stream;


public class RotateArray {


    public static void main(String[] args) {
        RotateArray rotateArray =  new RotateArray();
        int num[] = new int[]{1, 2, 3, 4, 5, 6, 7};

        rotateArray.rightrotate01(num, 3);
        System.out.println("-----------");
        rotateArray.rightrotate02(num, 3);
    }

    private void rightrotate02(int[] nums, int k) {
        int nums_lenth = nums.length;
        k = k % nums_lenth;
        if(nums == null || k < 0)
            throw new IllegalArgumentException("Illegal argument!");
        int first_length = nums_lenth - k;
        reverse(nums, 0, first_length-1);
        reverse(nums, first_length, nums_lenth-1);
        reverse(nums, 0, nums_lenth-1);
        for (int i:nums) {
            System.out.print(i+" ");
        }

    }

    private void reverse(int[] nums, int left, int right) {
        if(nums == null || nums.length ==1)
            return;
        while (left < right ){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    private void rightrotate01(int[] nums, int k) {
        int nums_length = nums.length;
        if( k > nums_length)
            k = k %nums_length;
        int res[] = new int[nums_length];

        for (int i = 0; i<k; i++) {
            res[i] = nums[nums_length-k+i];
        }

        int j = 0;
        for(int i = k; i<nums_length; i++ ){
            res[i] = nums[j];
            j++;
        }
        System.arraycopy(res, 0, nums,0,nums_length);
        for (int n:nums)
            System.out.print(n + " ");
    }
}
