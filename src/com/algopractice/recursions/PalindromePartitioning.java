package com.algopractice.recursions;

import java.util.ArrayList;
import java.util.List;

import static com.algopractice.twopointer.ValidPalindrome.isPalindrome;


public class PalindromePartitioning {
    public static void main(String[] args) {
        PalindromePartitioning partitioning = new PalindromePartitioning();
        List<List<String>> anslist = partitioning.partition("aab");
        for(List<String> ans: anslist){
            System.out.println(ans);
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path  = new ArrayList<>();
        partitionRecur(0, s, s.length(), path, ans);
        return  ans;
    }

    private void partitionRecur(int index, String s, int n, List<String> path, List<List<String>> ans) {

        if(index==n) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < n ; i++) {
            if(isPalindrome(s, index, i)){
                path.add(s.substring(index,i+1));
                partitionRecur(i+1, s, n, path,  ans);
                path.remove(path.size()-1);
            }
        }

    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
