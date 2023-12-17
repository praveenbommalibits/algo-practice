package com.algopractice.binarysearch;

/**
 * https://www.linkedin.com/posts/gabag26_codinginterview-leetcode-activity-7140558460676390917-LMG0?utm_source=share&utm_medium=member_desktop
 */
public class Search2DMatrix {
    public static void main(String[] args) {
        Search2DMatrix  matrix = new Search2DMatrix();
        int[][] martixin = new int[][]
                {{1},{60}};
        System.out.println(matrix.searchMatrix(martixin, 1));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int nr = matrix.length;
        int nc = matrix[0].length;
        int l =0, r = nr-1;

        while(l <= r) {
            int row = (r+l)/2;
            if(target > matrix[row][nc-1])
                l = row+1;
            else if (target < matrix[row][0])
                r = row-1;
            else
                break;
        }
        if(l<=r) {}
        else return false;
        r = (l+r)/2;// single row case
        int left =0, right = matrix[r].length-1;
        while(left <= right) {

            int mid = (right+left)/2;
            if(matrix[r][mid] == target)
                return true;
            else if(matrix[r][mid] > target)
                right = mid-1;
            else
                left = mid+1;
        }

        return false;
    }
}
