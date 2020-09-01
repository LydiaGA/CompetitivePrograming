package sample;

public class QuickSort {
    public static void main(String[] args) {
        int[] input = new int[]{4, 6, 5, 3, 2, 7};
        quickSort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }

    public static void quickSort(int[] list, int begin, int end){

        if (begin < end){
            int partition = partition(list, begin, end);
            quickSort(list, begin, partition - 1);
            quickSort(list, partition + 1, end);
        }
    }

    static int partition(int[] list, int begin, int end){
        int pivot = list[end];
        int i = begin - 1;
        for (int j = begin; j < end; j++){
            if (list[j] < pivot){
                i++;
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }

        int temp2 = list[i + 1];
        list[i + 1] = list[end];
        list[end] = temp2;

        return i + 1;
    }
}
