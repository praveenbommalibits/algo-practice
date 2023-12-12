package com.algopractice.twopointer;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {
        int s = 0;
        int e  = height.length-1;
        int maxArea  = 0;
        while(s < e) {
            int area = Math.min(height[s], height[e]) * (e-s);
            maxArea = Math.max(area, maxArea);
            if(height[s] < height[e])
                s++;
            else
                e--;
        }
        return maxArea;
    }

    public static int maxArea1(int[] height) {
        int s = 0;
        int e  = height.length-1;
        int maxArea  = 0;
        while(s < e) {
            int min_height  = Math.min(height[s], height[e]) ;
            maxArea = Math.max(min_height * (e-s), maxArea);
            while(s < e &&  height[s] <= min_height)
                s++;
            while(s < e &&  height[e] <= min_height)
                e--;
        }
        return maxArea;
    }
}
