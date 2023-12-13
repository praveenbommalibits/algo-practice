package com.algopractice.slidingwindow;

public class BestTimeBuySellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        if(prices != null && prices.length ==0)
            return 0;
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        int priceDiff =0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice)
                minPrice = prices[i];
            priceDiff = prices[i] - minPrice;
            if(priceDiff > maxProfit)
                maxProfit = priceDiff;
        }
        return maxProfit;
    }
}
