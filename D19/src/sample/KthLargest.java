package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KthLargest {

    List<Integer> numsList;
    int k;
    public KthLargest(int k, int[] nums) {
        this.numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        this.k = k;
        heapify(this.numsList);
    }

    public int add(int val) {

        insert(this.numsList, val);
        System.out.println(this.numsList.toString());
        List<Integer> temp = new ArrayList<>(this.numsList);
        int result = -1;
        for (int i = 0; i < k; i++) {
            result = delete(temp);
            String y = "hj";
            y.replaceAll("h", "i");
        }

        return result;
    }

    void heapify(List<Integer> input){
        int fistNonLeaf = (input.size() / 2) - 1;

        for (int i = fistNonLeaf; i >= 0; i--) {
            heapifyOne(input, i);
        }
    }

    void heapifyOne(List<Integer> input, int index){
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        int toSwap = index;

        if(left < input.size() && input.get(left) > input.get(index)){
            toSwap = left;
        }

        if(right < input.size() && input.get(right) > input.get(left)){
            toSwap = right;
        }

        if(toSwap != index){
            int temp = input.get(index);
            input.set(index, input.get(toSwap));
            input.set(toSwap, temp);

            heapifyOne(input, toSwap);
        }
    }

     void insert(List<Integer> input, int value){
        int index = input.size();
        input.add(value);

        int parent;
        while(true){
            parent = (index - 1) / 2;
            if(parent >= 0 && input.get(index) > input.get(parent)){
                int temp = input.get(index);
                input.set(index, input.get(parent));
                input.set(parent, temp);

                index = parent;
            }else{
                break;
            }
        }
    }

    int delete(List<Integer> input){
        int result = input.get(0);
        input.set(0, input.get(input.size() - 1));
        input.remove(input.size() - 1);
        heapifyOne(input, 0);
        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{};
        KthLargest kthLargest = new KthLargest(3, input);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}