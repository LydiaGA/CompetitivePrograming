package sample;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] merged = mergeSort(new int[]{2, 4, 7, 3, 1, 9, 8, 6, 5});
        for (int value : merged) {
            System.out.print(value + ", ");
        }
    }

    static int[] mergeSort(int[] input){
        if(input.length == 1){
            return input;
        }

        int[] firstHalf = Arrays.copyOfRange(input, 0, (input.length + 1)/2);
        int[] secondHalf = Arrays.copyOfRange(input, (input.length + 1)/2, input.length);

        firstHalf = mergeSort(firstHalf);
        secondHalf = mergeSort(secondHalf);

        return merge(firstHalf, secondHalf);
    }

    static int[] merge(int[] firstHalf, int[] secondHalf){
        int[] merged = new int[firstHalf.length + secondHalf.length];

        int i = 0, j = 0, k = 0;

        while(i < firstHalf.length && j < secondHalf.length){
            if(firstHalf[i] > secondHalf[j]){
                merged[k] = secondHalf[j];
                j++;
            }else{
                merged[k] = firstHalf[i];
                i++;
            }

            k++;
        }

        while(i < firstHalf.length){
            merged[k] = firstHalf[i];
            i++;
            k++;
        }

        while(j < secondHalf.length){
            merged[k] = secondHalf[j];
            j++;
            k++;
        }

        return merged;
    }
}
