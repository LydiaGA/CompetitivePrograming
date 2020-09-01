package sample;

public class SortByParity {

    public static void main(String[] args) {
        int[] result = sortArrayByParityII(new int[]{4,2,5,7, 9, 8});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }

    public static int[] sortArrayByParityII(int[] A) {
        int[] even = new int[A.length / 2];
        int[] odd = new int[A.length / 2];
        int[] result = new int[A.length];

        int evenCounter = 0, oddCounter = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0){
                even[evenCounter] = A[i];
                evenCounter++;
            }else{
                odd[oddCounter] = A[i];
                oddCounter++;
            }
        }

        int evenIndex = 0, oddIndex = 0;
        for (int i = 0; i < A.length; i++) {
            if(i % 2 == 0){
                result[i] = even[evenIndex];
                evenIndex++;
            }else{
                result[i] = odd[oddIndex];
                oddIndex++;
            }
        }

        return result;
    }
}
