package com.algopractice.greedy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MergeTripletsToFormTargetTriplet {
    public static void main(String[] args) {
        MergeTripletsToFormTargetTriplet triplet = new MergeTripletsToFormTargetTriplet();
        System.out.println(triplet.mergeTriplets(new int[][]{
                {2,5,3},{1,8,4},{1,7,5}
        }, new int[]{2,7,5}));
    }

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean f = false, s = false, t = false;
        for(int[] triplet: triplets) {
            if(triplet[0]>target[0] || triplet[1]>target[1] || triplet[2]>target[2])
                continue;

            if (!f && triplet[0] == target[0])
                f = true;
            if (!s && triplet[1]==target[1])
                s = true;
            if(!t && triplet[2] == target[2])
                t = true;

        }
        return f && s && t;
    }
}
