package sample;

public class DuplicateNumber {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
    }

    public static int findDuplicate(int[] nums) {
        int min, max, mid;
        for (int i = 0; i < nums.length; i++) {
            min = 1;
            max = nums.length;
            while (min <= max){
                mid = min + (max - min) / 2;
                System.out.println(mid + " " + nums[i]);
                if(mid == nums[i]){
                    return nums[i];
                }else if(nums[i] < mid){
                    max = mid - 1;
                }else{
                    min = mid + 1;
                }
            }
        }

        return -1;
    }
}
