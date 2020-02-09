package main;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int prevSum = 0;
        int currentSum = 0;
        for(int i = 0; i < nums.length; i++){
            currentSum = prevSum + nums[i];
            if(nums[i] > currentSum){
                currentSum = nums[i];
            }
            prevSum = currentSum;
            if(currentSum > max){
                max = currentSum;
            }
        }

        return max;
    }
}
