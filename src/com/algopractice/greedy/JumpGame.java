package com.algopractice.greedy;

public class JumpGame {
    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[]{2, 3, 1, 1, 4}));
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int targetReach = n-1;
        for (int idx = n-1; idx  >=0 ; idx --) {
            if(idx+nums[idx] >= targetReach) {
                targetReach = idx;
            }

        }
        return targetReach == 0;
    }
}
