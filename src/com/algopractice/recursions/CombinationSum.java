package com.algopractice.recursions;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum sum  = new CombinationSum();
        List<List<Integer>> listlist = sum.combinationSum(new int[]{2,3,6,7}, 7);
        for(List<Integer> list : listlist) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combinationSumRec(candidates, target, 0, candidates.length, ans, new ArrayList<Integer>());
        return ans;
    }

    private void combinationSumRec(int[] candidates, int target, int index, int n, List<List<Integer>> ans, ArrayList<Integer> ds) {

        if(index == n){
            if(target ==0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(candidates[index] <= target) {
            ds.add(candidates[index]);
            combinationSumRec(candidates, target-candidates[index], index, n, ans, ds);
            ds.remove(ds.size()-1);
        }
        combinationSumRec(candidates, target, index+1, n, ans, ds);
    }
}
