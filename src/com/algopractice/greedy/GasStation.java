package com.algopractice.greedy;

public class GasStation {
    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        System.out.println(gasStation.canCompleteCircuit(
                new int[]{1,2,3, 4,5},
                new int[]{3, 4,5,1, 2}
        ));

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int nGas = gas.length, nCost = cost.length;
        int gSum = 0, cSum = 0, total =0, resIndex=0;
        if(nGas != nCost) return -1;

        for (int i = 0; i < nGas; i++) {
            gSum +=gas[i];
            cSum +=cost[i];
        }
        if(gSum < cSum) return -1;

        for (int i = 0; i < nGas; i++) {
            total += gas[i] - cost[i];
            if(total < 0) {
                total=0;
                resIndex = i+1;
            }
        }

        return resIndex;
    }
}
