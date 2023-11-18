package com.algopractice.twopointer;


public class ValidPalindromeAtmostOne {

    public static void main(String[] args) {
        String s  = "gdabbag";
        System.out.println(isValidPalindrome(s));
    }

    private static boolean isValidPalindrome(String s) {

        for(int i = 0, j = s.length()-1; i < j; i++, j--) {

            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                if(Character.toLowerCase(s.charAt(i+1)) != Character.toLowerCase(s.charAt(j))) {
                    i++;
                } else{
                    j--;
                }

            }

        }
        return true;
    }
}
