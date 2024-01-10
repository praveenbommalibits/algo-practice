package com.algopractice.greedy;

import java.util.Stack;

public class ValidParathesisString {
    public static void main(String[] args) {
        ValidParathesisString parathesisString = new ValidParathesisString();
        System.out.println(parathesisString.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }

    public boolean checkValidString(String s) {
        int n = s.length();
        if (n==0) {
            return true;
        }
        Stack<Integer> parathesisStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='(') {
                parathesisStack.push(i);
            } else if (c=='*') {
                starStack.push(i);
            } else {
                if (!parathesisStack.isEmpty()) {
                   parathesisStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else return false;
            }
        }

        if(parathesisStack.size() > starStack.size()) return false;
        while ((!parathesisStack.isEmpty())) {
            if(starStack.isEmpty()) return false;

            if(starStack.peek() > parathesisStack.peek()) {
                parathesisStack.pop();
                starStack.pop();
            }
            else return false;
        }

        return true;
    }
}
