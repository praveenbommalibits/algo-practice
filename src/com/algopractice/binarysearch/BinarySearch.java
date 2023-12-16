package com.algopractice.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(new int[]{-1,0,3,5,9,12}, 9));
    }

    public int search(int[] nums, int target) {

        return searchrec(nums, 0, nums.length-1, target);
    }

    private int searchrec(int[] nums, int l, int r, int target) {

        if(r >=l) {
            int mid = l+(r-l)/2;
            if(nums[mid] == target)
                return mid;

            if(nums[mid] > target)
                return searchrec(nums,l, mid-1, target);

            return searchrec(nums,mid+1,r,target);

        }

        return -1;
    }
}
