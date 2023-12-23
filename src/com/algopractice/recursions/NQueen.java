package com.algopractice.recursions;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        List<List<String>> anslist = nQueen.solveNQueens(4);
        for(List<String> ans : anslist) {
            System.out.println(ans);
        }

    }

    public List<List<String>> solveNQueens(int n) {
        //board
        String board[][] = new String[n][n];
        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i< n;i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }
        solveNQ(0, board, ans,n);

        return ans;
    }

    private void solveNQ(int col, String[][] board, List<List<String>> ans, int n) {

        //base case
        if(col == n) {
            List<String> ds = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    s.append(board[i][j]);
                }
                ds.add(s.toString());
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int row = 0; row < n; row++) {
            if(isSafe(board,row, col,n)) {
                board[row][col]="Q";
                solveNQ(col+1, board, ans, n);
                board[row][col]=".";
            }

        }




    }

    private boolean isSafe(String[][] board, int row, int col, int n) {

        int drow = row, dcol = col;

        //top diagnoal
        while(row >= 0 && col >=0) {
            if(board[row][col].equals("Q")) return false;
            row--;
            col--;
        }

        //left direction
        row = drow;
        col = dcol;
        while(col >=0){
            if(board[row][col].equals("Q")) return false;
            col--;
        }

        row = drow;
        col = dcol;
        while(row <n && col >=0){
            if(board[row][col].equals("Q")) return false;
            row++;
            col--;
        }
        return true;
    }
}
