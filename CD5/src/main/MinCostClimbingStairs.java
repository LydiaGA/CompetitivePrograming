package main;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int next = cost[cost.length - 1];
        int nextNext = 0;
        int current;
        for(int i = cost.length - 2; i >= 0; i--){
            current = cost[i] + Math.min(next, nextNext);
            nextNext = next;
            next = current;
        }

        return Math.min(next, nextNext);
    }
}
