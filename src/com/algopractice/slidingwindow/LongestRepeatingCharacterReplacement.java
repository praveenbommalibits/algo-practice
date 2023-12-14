package com.algopractice.slidingwindow;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB",2));
    }

    public static int characterReplacement(String s, int k) {
        int arr[] = new int[26];
        int largestCnt =0,  begin =0, maxlen=0;
        int n = s.length();
        for (int end = 0; end < n; end++) {
            arr[s.charAt(end)-'A']++;
            largestCnt = Math.max(arr[s.charAt(end)-'A'], largestCnt);
            if(end-begin+1 - largestCnt > k) {
                arr[s.charAt(begin)-'A']--;
                begin++;
            }
            maxlen = Math.max(maxlen, end-begin+1);
        }

        return maxlen;
    }
}
