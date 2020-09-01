package sample;

public class LargestPerimeter {
    public static void main(String[] args) {
        int result = largestPerimeter(new int[]{3, 2, 3, 4});
        System.out.print(result);
    }

    public static int largestPerimeter(int[] A) {
        A = sort(A);

        int perimeter = 0;

        int lastIndex = A.length - 1;
        for (int i = 0; i < A.length - 2; i++) {
            System.out.println(A[lastIndex - i]);
            System.out.println(A[lastIndex - i] < A[lastIndex - 1 - i] + A[lastIndex - 2 - i]);
            //System.out.println(A[lastIndex - 2 - i]);
            if(A[lastIndex - i] < A[lastIndex - 1 - i] + A[lastIndex - 2 - i]){
                perimeter = A[lastIndex - i] + A[lastIndex - 1 - i] + A[lastIndex - 2 - i];
                break;
            }
        }

        return perimeter;
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
