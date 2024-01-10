package com.algopractice.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        PartitionLabels labels = new PartitionLabels();
        List<Integer> ans = labels.partitionLabels("ababcbacadefegdehijhklij");
        ans.forEach(a-> System.out.print(a+" "));
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        if (n==0) {
            return ans;
        }
        if (n==1) {
            return List.of(n);
        }

        int[] lastChar = new int[26];
        for (int i = 0; i < n ; i++) {
            char ch = s.charAt(i);
            lastChar[ch-'a'] = i;
        }
        int prevLastIndexLen = -1;
        int partitionIndexLen =0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            partitionIndexLen = Math.max(partitionIndexLen, lastChar[ch-'a']);
            if (partitionIndexLen==i) {
                ans.add(partitionIndexLen-prevLastIndexLen);
                prevLastIndexLen = partitionIndexLen;
            }
        }
        return ans;
    }
}
