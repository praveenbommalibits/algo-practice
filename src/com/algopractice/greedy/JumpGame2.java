package com.algopractice.greedy;

public class JumpGame2 {
    public static void main(String[] args) {
        JumpGame2 game2 = new JumpGame2();
        System.out.println(game2.jump(new int[]{2,3,1,1,4}));
    }

    public int jump(int[] nums) {
        int destinationLen = nums.length-1;
        int totalJumps = 0;
        int coverage = 0;
        int lastJumpIndex = 0;

        if(nums.length == 1) return 0;

        for (int i = 0; i < nums.length; i++) {
            coverage = Math.max(coverage, i+nums[i]);
            if(i==lastJumpIndex) {
                lastJumpIndex = coverage;
                totalJumps++;

                if(coverage >= destinationLen)
                    return totalJumps;
            }


        }

        return totalJumps;
    }
}
