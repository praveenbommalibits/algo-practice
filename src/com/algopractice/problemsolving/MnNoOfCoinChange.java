package com.algopractice.problemsolving;

public class MnNoOfCoinChange {

    public static void main(String[] args) {
        int coins[] = {9, 6, 5, 1};
        int m = coins.length;
        System.out.println("Min coins required is "+minCoins(coins, m, 11));
    }

    private static int minCoins(int[] coins, int m, int target) {
        if (target == 0)
            return 0;
        int res = Integer.MAX_VALUE;

        for(int  i=0; i< m; i++) {
            if(coins[i] <= target) {
                int sub_res = minCoins(coins, m, target-coins[i]);
                if(sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
                    res = sub_res + 1;

            }
        }

        return 0;
    }
}
