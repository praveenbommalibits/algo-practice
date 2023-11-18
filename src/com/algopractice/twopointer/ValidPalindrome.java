package com.algopractice.twopointer;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "ababada";
        System.out.println(isValidPalindrome(s));
    }

    private static boolean isValidPalindrome(String s) {
        for(int i =0, j = s.length()-1; i < j; i++,j-- ) {

            while(i < j && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            while(i < j && !Character.isLetterOrDigit(s.charAt(j)))
                j--;
            if(i < j && Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j) )) {
                System.out.println("valid");
            } else {
                return isPalindrome(s,i+1, j ) || isPalindrome(s, i, j-1);
            }

        }
        return true;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while(i<j){
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }
            else
                return false;
        }
        System.out.println("asdsad");
        return true;
    }
}
