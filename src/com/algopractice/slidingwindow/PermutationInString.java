package com.algopractice.slidingwindow;

public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidboaooo"));
    }

    public static boolean checkInclusion(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();
        int m[] = new int[26];
        int left = 0, right =0, tc = n1;
        for (char c : s1.toCharArray()) {
            m[c-'a']++;
        }

        while(right < n2) {
            if(m[s2.charAt(right++)-'a']-- > 0) {
                tc--;
            }
            if(tc==0) return true;

            if(right-left == n1 && m[s2.charAt(left++)-'a']++ >= 0)
                tc++;
        }
        return false;
    }
}
