package sample;

public class SmallestDivisor {
    public static void main(String[] args) {
        System.out.println(smallestDivisor(new int[]{}, 5));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int min = 1, max = threshold, mid;
        int sum;
        int smallestDivisor = threshold;

        while(min <= max){
            sum = 0;
            mid = min + (max - min) / 2;
            for (int i = 0; i < nums.length; i++) {
                sum += Math.ceil((float)nums[i] / mid);
            }

            if(sum <= threshold){
                if(mid < smallestDivisor){
                    smallestDivisor = mid;
                }
                max = mid - 1;
            }else{
                min = mid + 1;
            }

        }

        return smallestDivisor;
    }
}
