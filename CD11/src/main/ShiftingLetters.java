package main;

import java.util.Arrays;

public class ShiftingLetters {

    public static void main(String[] args) {
	// write your code here
    }

    public String shiftingLetters(String S, int[] shifts) {
        long[] shiftSums = new long[shifts.length];
        long currentSum = 0;

        StringBuilder sb = new StringBuilder();

        for(int i = shifts.length - 1; i >= 0; i--){
            shiftSums[i] = shifts[i] + currentSum;
            currentSum = shiftSums[i];
        }

        System.out.println(Arrays.toString(shiftSums));

        for(int i = 0; i < S.length(); i++){
            System.out.println((S.charAt(i) - 97 + shiftSums[i]));
            sb.append((char)(((S.charAt(i) - 97 + shiftSums[i]) % 26) + 97));
        }

        return sb.toString();
    }
}
