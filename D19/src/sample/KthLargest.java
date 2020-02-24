package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KthLargest {

    PriorityQueue<Integer> heap;
    int[] nums;
    int k;
    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();
        this.nums = nums;
        this.k = k;

        for(int i = 0; i < nums.length; i++){
            if(heap.size() == k){
                if(heap.peek() < nums[i]){
                    heap.poll();
                    heap.add(nums[i]);
                }
            }else{
                heap.add(nums[i]);
            }
        }


    }

    public int add(int val) {
        if(heap.size() == k){
            if(heap.peek() < val){
                heap.poll();
                heap.add(val);
            }
        }else{
            heap.add(val);
        }

        return heap.peek();
    }
    public static void main(String[] args) {
        int[] input = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, input);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
