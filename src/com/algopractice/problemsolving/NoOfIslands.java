package com.algopractice.problemsolving;

public class NoOfIslands {
    public static void main(String[] args) {
        int M[][] = new int[][] {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        } ; 
        NoOfIslands noi = new NoOfIslands();
        System.out.println("no of islands : "+noi.countIslands(M));
    }

    private int countIslands(int[][] m) {
        return 0;
    }
}
