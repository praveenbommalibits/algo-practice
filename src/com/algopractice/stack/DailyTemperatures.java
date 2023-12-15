package com.algopractice.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures temperatures = new DailyTemperatures();
        System.out.println(Arrays.toString(temperatures.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    public int[] dailyTemperatures(int[] temperatures) {
       int n = temperatures.length;
       int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
       for(int r = n-1; r >= 0; r--) {

           while(!st.isEmpty() && temperatures[r] > temperatures[st.peek()]) {
               st.pop();
           }

           if(!st.isEmpty()) {
               ans[r] = st.peek()-r;
           }

           st.push(r);
       }

        return ans;
    }
}
