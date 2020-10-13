package Week6;

import java.util.HashMap;
import java.util.Map;

public class DivideArray {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = nums[0];
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
                map.replace(nums[i], map.get(nums[i]) + 1);
            }

            if(nums[i] < min){
                min = nums[i];
            }

            if(nums[i] > max){
                max = nums[i];
            }

        }



        boolean result = true;
        boolean found = true;

        while(result && found){
            int count = 0;
            int current = 0;
            for(int i = min; i <= max; i++){
                if(map.containsKey(i) && count > 0 && map.get(i) == 0){
                    break;
                }
                if(map.containsKey(i) && map.get(i) != 0){
                    if(current != 0 && current != i - 1){
                        result = false;
                        break;
                    }
                    current = i;
                    count++;
                    map.replace(i, map.get(i) - 1);
                }

                if(count == k){
                    break;
                }
            }

            if(count == 0){
                found = false;
                break;
            }

            if(count < k){
                result = false;
                break;
            }

        }

        return result;
    }
}
