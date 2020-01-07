package sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Map.Entry.*;
import static java.util.stream.Collectors.*;

public class DistantBarcodes {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(distantBarcodes(new int[]{2,5,1,5,5})));
    }

    public int[] distantBarcodes(int[] barcodes){
        Map<Integer, Integer> countDictionary = new HashMap<>();

        for (int barcode : barcodes) {
            if (countDictionary.containsKey(barcode)) {
                countDictionary.replace(barcode, countDictionary.get(barcode) + 1);
            } else {
                countDictionary.put(barcode, 1);
            }
        }



        System.out.println(countDictionary.toString());

        return barcodes;

    }

    public static int[] sort(int[] nums){
        int[] sorted = new int[nums.length];

        if(nums.length == 0){
            return sorted;
        }

        int max = getMax(nums);

        int[] count = new int[max + 1];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]] += 1;
        }

        int counter = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                sorted[counter] = i;
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
