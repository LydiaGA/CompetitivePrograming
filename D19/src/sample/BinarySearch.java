package sample;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    public static int search(int[] nums, int target) {
        int min = 0, max = nums.length - 1, mid;
        int index = -1;
        while(min <= max){
            mid = min + (max - min) / 2;
            if(target == nums[mid]){
                index = mid;
                break;
            }else if (target < mid){
                max = mid;
            }else{
                min = mid + 1;
            }
        }

        return index;
    }
}
