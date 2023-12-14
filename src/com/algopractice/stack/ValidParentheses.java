package com.algopractice.stack;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        //System.out.println(isValid("]]"));
        System.out.println(isValid1(""));
    }

    private static boolean isValid1(String s) {
        Stack<Character> parStack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c=='(')
                parStack.push(')');
            else if (c =='[')
                parStack.push(']');
            else if (c=='{')
                parStack.push('}');
            else if(parStack.isEmpty() || parStack.pop()!=c)
                return false;


        }
        return s.length() !=0  && parStack.isEmpty();

    }

    public static boolean isValid(String s) {
        Stack<Character> parStack  =  new Stack<>();
        if(s.length()==0)
            return false;
        for (char c :s.toCharArray()) {
            if(c=='('|c=='['||c=='{')
                parStack.push(c);
            else {
                if(parStack.isEmpty())
                    return false;
                char ctop = parStack.peek();
                if(c==')'&&ctop=='(' || c==']'&&ctop=='[' || c=='}'&&ctop=='{' ) {
                    parStack.pop();
                } else
                    return false;
            }
        }
        if(!parStack.isEmpty())
            return false;
        return true;
    }
}
