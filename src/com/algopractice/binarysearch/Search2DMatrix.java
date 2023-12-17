package com.algopractice.binarysearch;

/**
 * https://www.linkedin.com/posts/gabag26_codinginterview-leetcode-activity-7140558460676390917-LMG0?utm_source=share&utm_medium=member_desktop
 */
public class Search2DMatrix {
    public static void main(String[] args) {
        Search2DMatrix  matrix = new Search2DMatrix();
        int[][] martixin = new int[][]
                {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(matrix.searchMatrix(martixin, 3));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int totalRows = matrix.length;
        int c = matrix[0].length;
        int l =0, r = totalRows-1;

        while(l <= r) {
            int mid = (l+r)/2;
            //if(matrix[mid][0][1] < target < matrix[mid][0][c-1] )
            if(matrix[mid][0] > target)
                r = mid-1;
            else
                l = mid+1;
        }

        return false;
    }
}
