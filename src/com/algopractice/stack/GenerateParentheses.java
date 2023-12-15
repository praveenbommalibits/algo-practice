package com.algopractice.stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(2));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        genParenthesis(list, n,0, 0, new StringBuilder());
        return  list;
    }

    private void genParenthesis(List<String> list, int n, int open, int close, StringBuilder currString) {

        if(currString.length()==n*2) {
            list.add(currString.toString());
        }

        if(open < n) {
            genParenthesis(list, n, open+1, close, currString.append("("));
            currString.deleteCharAt(currString.length() - 1);
        }
        if(close < open) {
            genParenthesis(list, n, open, close+1, currString.append(")"));
            currString.deleteCharAt(currString.length() - 1);

        }
    }
}
