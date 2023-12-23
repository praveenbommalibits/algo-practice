package com.algopractice.recursions;

import java.util.ArrayList;
import java.util.List;

public class NQueenOptimal {
    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        List<List<String>> anslist = nQueen.solveNQueens(4);
        for(List<String> ans : anslist) {
            System.out.println(ans);
        }

    }

    public List<List<String>> solveNQueens(int n) {
        //board

        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i< n;i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }
        solveNQ(0, board, ans,n);

        return ans;
    }
}
