package main;

import java.util.HashMap;
import java.util.Map;

public class RangeSum {
    Map<Integer, Integer> sums;
    int sum = 0;
    public RangeSum(int[] nums) {
        sums = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            sums.put(i, sum);
        }

        System.out.println(sums.toString());
        System.out.println(sum);
    }

    public int sumRange(int i, int j) {
        if(i == 0){
            return sums.get(j);
        }
        return sums.get(j) - sums.get(i - 1);
    }
}
