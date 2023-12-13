package com.algopractice.arrays_hashing;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] out = productExceptSelf(new int[]{1,2,3,4});
        for(int i : out){
            System.out.print(i+" ");
        }
    }
    public static int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int out[] =  new int[n];
        if(n < 1)
            return new int[0];
        int product = 1;
        for(int i = 0; i<n; i++) {
            product = product*nums[i];
            out[i] = product;
        }

        product =1;
        for(int  i =n-1; i>0; i--) {
            out[i] = out[i-1]*product;
            product = product*nums[i];
        }
        out[0] = product;


        return out;
    }
}
