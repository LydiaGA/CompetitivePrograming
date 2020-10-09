package Week5;

import java.util.PriorityQueue;

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2 - num1);
        for(int i = 0; i < nums.length; i++){
            queue.add(nums[i]);
        }

        int result = -1;
        for(int i = 0; i < k; i++){
            result = queue.poll();
        }

        return result;

    }
}
