package main;

public class SumToZero {

    public int[] sumZero(int n) {
        int[] result = new int[n];
        int half = n % 2 == 0 ? n / 2 : (n - 1) / 2;
        int counter = 0;
        for(int i = 1; i <= half; i++){
            result[counter] = i;
            counter++;
            result[counter] = -1 * i;
            counter++;
        }

        return result;
    }
}
