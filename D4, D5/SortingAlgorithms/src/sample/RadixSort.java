package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadixSort {

    public static void main(String[] args) {
        int[] input = {324, 67, 43, 159};

        int max = getMax(input);

        int count = 1;
        while(max != 0){
            input = countSortByLastDigit(input, (int) Math.pow(10, count));
            max /= 10;
            count++;
        }

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i] + " ");
        }
    }

    static int[] countSortByLastDigit(int[] input, int base){

        int[] sorted = new int[input.length];
        int max = getMax(input);

        int[] count = new int[max + 1];

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            int digit  = (input[i] % base) / (base / 10);
            if(map.containsKey(digit)){
                map.get(digit).add(input[i]);
            }else{
                List<Integer> numbersContainingDigit = new ArrayList<>();
                numbersContainingDigit.add(input[i]);
                map.put(digit, numbersContainingDigit);
            }
            count[digit] += 1;
        }

        int counter = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                sorted[counter] = map.get(i).get(j);
                counter++;
            }
        }

        return sorted;


    }

    static int getMax(int[] array){
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] > max){
                max = array[i];
            }
        }

        return max;
    }
}
