package sample;

import java.util.Arrays;

public class DistantBarcodes {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(distantBarcodes(new int[]{2,5,1,5,5})));
    }

    public static int[] distantBarcodes(int[] barcodes){
        int[] rearranged = new int[barcodes.length];

        for (int i = 0; i < rearranged.length; i++) {
            if(i == 0){
                rearranged[i] = barcodes[0];
                barcodes[0] = 0;
                continue;
            }
            for (int j = 0; j < barcodes.length; j++) {
                if(rearranged[i-1] != barcodes[j] && barcodes[j] != 0){
                    rearranged[i] = barcodes[j];
                    barcodes[j] = 0;
                    break;
                }
            }
        }

        return rearranged;

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
