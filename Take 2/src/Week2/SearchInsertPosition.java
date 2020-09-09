package Week2;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int min = 0; int max = nums.length - 1, mid;
        while(min <= max) {
            mid = min + (max - min) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(mid == 0 && target < nums[mid]){
                return mid;
            }else if(mid != 0 && target > nums[mid - 1] && target < nums[mid]) {
                return mid;
            }else if(mid == nums.length - 1 && target > nums[mid]){
                return mid + 1;
            }else if(target < nums[mid]){
                max = mid;
            }else{
                min = mid + 1;
            }
        }

        return 0;
    }
}
