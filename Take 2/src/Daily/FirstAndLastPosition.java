package Daily;

public class FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int min = 0, max = nums.length, mid;

        while(min < max){
            mid = min + (max - min) / 2;
            if(nums[mid] == target && (mid == 0 || nums[mid - 1] != target)){
                result[0] = mid;
                break;
            }else if(nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] != target)){
                result[1] = mid;
                max = mid;
            }else if(target <= nums[mid]){
                max = mid;
            }else{
                min = mid + 1;
            }
        }

        if(result[1] == -1){
            int min2 = 0, max2 = nums.length, mid2;

            while(min2 < max2){
                mid2 = min2 + (max2 - min2) / 2;
                if(nums[mid2] == target && (mid2 == nums.length - 1 || nums[mid2 + 1] != target)){
                    result[1] = mid2;
                    break;
                }else if(target < nums[mid2]){
                    max2 = mid2;
                }else if(target >= nums[mid2]){
                    min2 = mid2 + 1;
                }
            }
        }

        return result;
    }
}
