package com.algopractice.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left =0, right  =0;
        Map<Character,Integer> charMap = new HashMap<>();
        int lls = 0;
        while(right  < n) {

            char c = s.charAt(right);
            if(charMap.containsKey(c)) {
                left = Math.max(charMap.get(c)+1, left);
                charMap.put(c,left);
            }
            charMap.put(c, right);
            lls = Math.max(right-left+1, lls);
            right++;


        }

        return lls;
    }
}
