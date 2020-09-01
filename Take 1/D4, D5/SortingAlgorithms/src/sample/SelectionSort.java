package sample;

import java.util.ArrayList;

public class SelectionSort {
    public static void main(String[] args) {
        int[] input = {3, 2, 7, 8, 9, 5, 6};

        int[] result = sort(input);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] sort(int[] input){
        for (int i = 0; i < input.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < input.length; j++) {
                if(input[minIndex] > input[j]){
                    minIndex = j;
                }
            }

            int temp = input[i];
            input[i] = input[minIndex];
            input[minIndex] = temp;

        }

        return input;
    }
}
