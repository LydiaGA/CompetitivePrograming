package sample;

import java.util.ArrayList;

public class InsertionSort {

    public static void main(String[] args) {
	    int[] input = {3, 2, 7, 8, 9, 5, 6};

        ArrayList<Integer> sorted = new ArrayList<Integer>();

        for(int i = 0; i < input.length; i++){
            int size = sorted.size();
            boolean placed = false;
            for (int j = 0; j < size; j++) {
                if(input[i] < sorted.get(j)){
                    sorted.add(j, input[i]);
                    placed = true;
                    break;
                }
            }
            if(!placed){
                sorted.add(input[i]);
            }
        }

        System.out.println(sorted);

    }
}
