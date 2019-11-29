package sample;

import java.util.ArrayList;

public class RelativeSort {
    public static void main(String[] args) {
        int[] result = relativeSortArray(new int[]{28,6,22,8,44,17}, new int[]{22,28,8,6});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];

        arr1 = sort(arr1);

        int counter = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if(arr2[i] == arr1[j]){
                    result[counter] = arr1[j];
                    counter++;
                }
            }
        }

        for (int i = 0; i < arr1.length; i++) {
            if(!inArray(arr2, arr1[i])){
                result[counter] = arr1[i];
                counter++;
            }
        }

        return result;
    }

    static boolean inArray(int[] array, int value){
        boolean test = false;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == value){
                test  = true;
            }
        }

        return test;
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
