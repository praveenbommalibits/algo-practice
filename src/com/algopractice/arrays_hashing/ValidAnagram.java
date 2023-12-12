package com.algopractice.arrays_hashing;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram1("anagram", "nagaram"));
    }

    private static boolean isAnagram1(String anagram, String nagaram) {
        return false;
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length() )
            return false;

        int char_count[] = new int[26];
        for(int i=0; i< s.length();i++) {
            char_count[s.charAt(i)-'a']++;
            char_count[t.charAt(i)-'a']--;
        }

        for(int count: char_count) {
            if(count != 0)
                return false;
        }

        return true;
    }
}
