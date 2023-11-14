package com.algopractice.problemsolving;

/**
 * Longest palindrome substring
 */
public class longestpalindrome {

    public static void main(String[] args) {
        String str = "abdcdba";
        System.out.println("Longest palindrome length is : "+longestPalindromeSubstr(str));
    }

    private static int longestPalindromeSubstr(String str) {
        int n = str.length();
        if(n < 2)
            return n;
        int maxlength = 1, start =0;
        int low=0, high = 0;
        for(int i=0; i<n; i++) {
            low = i - 1;
            high = i + 1;
            while (high < n && str.charAt(high) == str.charAt(i))
                high++;
            while (low >= 0 && str.charAt(low) == str.charAt(i))
                low--;
            while (low >= 0 && high < n && str.charAt(low) == str.charAt(high)) {
                low--;
                high++;
            }

            int length = high - low - 1;
            if (maxlength < length) {
                maxlength = length;
                start = low + 1;
            }
        }

        return maxlength;
    }
}
