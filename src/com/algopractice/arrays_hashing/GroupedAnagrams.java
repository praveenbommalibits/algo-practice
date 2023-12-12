package com.algopractice.arrays_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupedAnagrams {
    public static void main(String[] args) {
        List<List<String>> lgroup = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        for(List<String> group: lgroup) {
            System.out.println(group);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length ==0)
            return new ArrayList<>();

        Map<String, List<String>> anagramGroup =  new HashMap<>();
        for(String str: strs) {
            int charcount[] = new int[26];
            for(char c: str.toCharArray()) {
                charcount[c-'a']++;
            }
            StringBuilder builder = new StringBuilder();
            for(int count: charcount) {
                builder.append(count).append("#");
            }
            String key = builder.toString();

            anagramGroup.computeIfAbsent(key, k->new ArrayList<>()).add(str);
        }

        return new ArrayList<>(anagramGroup.values());
    }
}
