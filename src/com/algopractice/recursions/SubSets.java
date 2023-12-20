package com.algopractice.recursions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSets {
    public static void main(String[] args) {
        SubSets subSets = new SubSets();
        List<List<Integer>> listlist = subSets.subsets(new int[]{1,2,1});
        for(List<Integer> s : listlist) {
            System.out.println(s);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {

        Set<List<Integer>> subsets = new HashSet<>();

        subsetsRec(nums,new ArrayList<>(), subsets,nums.length, 0);
        return new ArrayList<>(subsets);
    }

    private void subsetsRec(int[] nums, List<Integer> subset, Set<List<Integer>> subsets, int n, int i) {

        if(i==n) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        subsetsRec(nums, subset, subsets, n, i+1);
        subset.remove(subset.size()-1);
        subsetsRec(nums, subset, subsets, n, i+1);


    }
}
