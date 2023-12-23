package com.algopractice.recursions;

import java.util.ArrayList;
import java.util.List;

public class Permutation2 {

    public static void main(String[] args) {
        Permutation2 permutations = new Permutation2();
        List<List<Integer>> listans = permutations.permute(new int[]{1,2,3});
        for(List<Integer> ans : listans) {
            System.out.println(ans);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int  n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        permuteRecur(0, nums,n, ans);
        return ans;
    }

    private void permuteRecur(int index, int[] nums, int n, List<List<Integer>> ans) {

        if(index==n){
            List<Integer> ds = new ArrayList<>();
            for(int i: nums) {
                ds.add(i);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < n; i++) {
                swap(i, index, nums);
                permuteRecur(index+1, nums,n, ans);
                swap(i, index, nums);
        }
    }

    private void swap(int i, int index, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}
