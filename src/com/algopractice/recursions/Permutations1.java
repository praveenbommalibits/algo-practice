package com.algopractice.recursions;

import java.util.ArrayList;
import java.util.List;

public class Permutations1 {
    public static void main(String[] args) {
        Permutations1 permutations = new Permutations1();
        List<List<Integer>> listans = permutations.permute(new int[]{1,2,3});
        for(List<Integer> ans : listans) {
            System.out.println(ans);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int  n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean freq[] = new boolean[n];
        permuteRecur(nums,n, ans, freq, new ArrayList<Integer>());
        return ans;
    }

    private void permuteRecur(int[] nums, int n, List<List<Integer>> ans, boolean[] freq, ArrayList<Integer> ds) {

        if(ds.size()==n){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!freq[i]){
                freq[i] = true;
                ds.add(nums[i]);
                permuteRecur(nums,n, ans, freq,ds);
                ds.remove(ds.size()-1);
                freq[i]= false;

            }
        }
    }
}
