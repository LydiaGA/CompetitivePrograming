package Week6;

public class JumpGame {
    public int jump(int[] nums) {
        int[] jumps = new int[nums.length];
        int lastIndex = nums.length - 1;
        jumps[lastIndex] = 0;
        for(int i = lastIndex - 1; i >= 0; i--){
            int minIndex = getMinIndex(i + 1, i + nums[i], jumps);
            jumps[i] = jumps[minIndex] + 1;


        }

        return jumps[0];
    }

    int getMinIndex(int start, int end, int[] jumps){
        int min = jumps[start];
        int minIndex = start;

        for(int i = start + 1; i <= end; i++){
            if(i > jumps.length - 1){
                break;
            }

            if(jumps[i] < min){
                min = jumps[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}
