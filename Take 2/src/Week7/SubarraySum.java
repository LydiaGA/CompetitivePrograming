package Week7;

public class SubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        for(int i = 2; i <= nums.length; i++){
            boolean result = doSum(nums, i, k);
            if(result){
                return true;
            }
        }
        return false;

    }

    boolean doSum(int[] nums, int n, int k){
        int window = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(window < n){
                sum += nums[i];
                window += 1;
            }else{
                if((k == 0 && sum == 0) || (k != 0 && sum % k == 0)){
                    return true;
                }
                sum += nums[i];
                sum -= nums[i - n];
            }
        }

        if((k == 0 && sum == 0) || (k != 0 && sum % k == 0)){
            return true;
        }else{
            return false;
        }
    }
}
