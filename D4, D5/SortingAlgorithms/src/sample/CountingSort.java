package sample;

public class CountingSort {
    public static void main(String[] args) {
        int[] input = {3, 2, 7, 8, 9, 5, 6, 3};
        int[] sorted = new int[input.length];
        int max = getMax(input);
        
        int[] count = new int[max + 1];

        for (int i = 0; i < input.length; i++) {
            count[input[i]] += 1;
        }

        int counter = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                sorted[counter] = i;
                counter++;
            }
        }

        for (int i = 0; i < sorted.length; i++) {
            System.out.print(sorted[i] + " ");
        }
        
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
