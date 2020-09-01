package main;

public class HouseRobber {
    public int rob(int[] nums) {
        int max = 0;
        int prevMax = 0;
        int current = 0;

        for(int i = nums.length - 1; i >= 0; i--){

            current = nums[i] + prevMax;
            prevMax = max;
            if(current >= max){
                max = current;
            }
        }

        return max;
    }
}
