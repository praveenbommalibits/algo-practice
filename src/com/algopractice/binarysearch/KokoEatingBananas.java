package com.algopractice.binarysearch;

public class KokoEatingBananas {
    public static void main(String[] args) {
        KokoEatingBananas bananas = new KokoEatingBananas();
        System.out.println(bananas.minEatingSpeed(new int[]{3,6,7,11}, 8));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxRange = Integer.MIN_VALUE;
        for (int pile: piles) {
            maxRange = Math.max(pile, maxRange);
        }
        int low=1, high=maxRange;
        while(low <= high){
            int mid = (low+high)/2;
            int rt = requireTime(piles, mid);
            if(rt <= h) {
                high = mid-1;
            } else {
                low = mid+1;
            }

        }

        return low;
    }

    private int requireTime(int[] piles, int k) {

        int requiredTime = 0;
        for (int pile: piles) {
            requiredTime += Math.ceil((double) pile / (double) k);
        }
        return requiredTime;
    }
}
