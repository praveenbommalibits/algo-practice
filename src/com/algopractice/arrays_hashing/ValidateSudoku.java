package com.algopractice.arrays_hashing;

public class ValidateSudoku {
    public static void main(String[] args) {

        char[][] board = {
                            {'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}
                         };
        System.out.println(isValidSudoku(board));
    }

    public static  boolean isValidSudoku(char[][] board) {

        for(int i=0; i<9; i++) {
            for(int j=0; j <9;j++) {
                char c = board[i][j];
                if(c >= '0' && c <= '9' && !isValid(board,i,j)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int r, int c) {

        for(int i =0; i<9; i++) {
            //row chaking
            if(r!=i && board[i][c]==board[r][c]) return false;
            if(c!=i && board[r][i]==board[r][c]) return false;
        }

        //3*3 grid validation
        int rs = 3*(r/3);
        int cs = 3*(c/3);
        for(int  i=rs; i<rs+3; i++) {
            for(int j=cs; j<cs+3; j++) {
                if(i!=r && j!=c && board[i][j]==board[r][c])
                    return false;
            }
        }

        return true;
    }
}
