package com.algopractice.twopointer;

import java.util.Arrays;
import java.util.List;

public class TwoSumProblem {
    public static void main(String[] args) {
        int[] numbers = new int[]{-1,0};
        int target = -1;
        System.out.println(twoSum(numbers,target));
    }

    private static int[] twoSum(int[] numbers, int target) {
        int[] indices = new int[2];
        if(numbers.length < 2)
            return indices;
        int  i =0, j = numbers.length-1;
        while(i<j) {
            int derivedSum = numbers[i] + numbers[j];
            if( derivedSum == target) {
                indices[0] = i+1;
                indices[1] = j+1;
                return indices;
            } else if (derivedSum > target) {
                j--;
            } else {
                i++;
            }
        }

        return indices;
    }
}
