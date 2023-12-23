package com.algopractice.recursions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueenOptimal {
    public static void main(String[] args) {
        NQueenOptimal nQueen = new NQueenOptimal();
        List<List<String>> anslist = nQueen.solveNQueens(4);
        for(List<String> ans : anslist) {
            System.out.println(ans);
        }

    }
    private  List<String> initializeBoard(int n) {
        List<String> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        // Create an empty row of size n (filled with '.')
        for (int i = 0; i < n; i++) {
            sb.append('.');
        }
        // Add n rows to the board
        for (int i = 0; i < n; i++) {
            board.add(sb.toString());
        }
        return board;
    }

    public List<List<String>> solveNQueens(int n) {
        //board

        List<List<String>> ans = new ArrayList<>();
        List<String> board = initializeBoard(n);
        List<Integer> leftRow = new ArrayList<>(Collections.nCopies(n, 0));
        List<Integer> lowerDiag = new ArrayList<>(Collections.nCopies(2*n-1, 0));
        List<Integer> upperDiag = new ArrayList<>(Collections.nCopies(2*n-1, 0));

        solveNQ(0, board, ans,n,leftRow,lowerDiag, upperDiag);

        return ans;
    }

    private void solveNQ(int col, List<String> board, List<List<String>> ans, int n, List<Integer> leftRow, List<Integer> lowerDiag, List<Integer> upperDiag) {
        //base case
        if(col==n) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if(leftRow.get(row) == 0 && lowerDiag.get(row+col)==0 && upperDiag.get((n-1)+(col-row))==0) {
                StringBuilder cRow = new StringBuilder(board.get(row));
                cRow.setCharAt(col, 'Q');
                board.set(row, cRow.toString());

                leftRow.set(row, 1);
                lowerDiag.set(row+col, 1);
                upperDiag.set((n-1)+(col-row), 1);

                solveNQ(col+1, board, ans, n, leftRow, lowerDiag, upperDiag);

                cRow = new StringBuilder(board.get(row));
                cRow.setCharAt(col, '.');
                board.set(row, cRow.toString());

                leftRow.set(row, 0);
                lowerDiag.set(row+col, 0);
                upperDiag.set((n-1)+(col-row), 0);

            }
        }
    }
}
