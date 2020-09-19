package Daily;

import java.util.ArrayList;
import java.util.Arrays;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        ArrayList<ArrayList<Integer>> tempMultiples = new ArrayList<>();

        for (int i = 0; i < num1.length(); i++){
            ArrayList<Integer> tempMultiple = new ArrayList<Integer>();
            int carry = 0;
            for (int k = 0; k < i; k++) {
                tempMultiple.add(0);
            }
            for (int j = 0; j < num2.length(); j++){
                int digitMultiple = Integer.parseInt(String.valueOf(num1.charAt(num1.length() - i - 1))) * Integer.parseInt(String.valueOf(num2.charAt(num2.length() - j - 1))) + carry;

                if(digitMultiple / 10 > 0){
                    carry = digitMultiple / 10;
                }else{
                    carry = 0;
                }
                tempMultiple.add(digitMultiple % 10);

                if(j == num2.length() - 1 && digitMultiple / 10 != 0){
                    tempMultiple.add(digitMultiple / 10);
                }

            }
            tempMultiples.add(tempMultiple);
        }

        // System.out.println(tempMultiples);

        String result = invert((ArrayList<Integer>) tempMultiples.get(0));
        for (int i = 1; i < tempMultiples.size(); i++) {
            result = add(result, invert(tempMultiples.get(i)));
        }

        return result;
    }

    String invert(ArrayList<Integer> input){
        StringBuilder result = new StringBuilder();
        for (int i = input.size() - 1; i >= 0; i--) {
            result.append(input.get(i));
        }

        return result.toString();
    }


    String add(String number1, String number2) {
        ArrayList<String> longerNumber = new ArrayList<String>(Arrays.asList(number1.split("")));
        ArrayList<String> shorterNumber = new ArrayList<String>(Arrays.asList(number2.split("")));

        if (shorterNumber.size() > longerNumber.size()) {
            ArrayList<String> temp = longerNumber;
            longerNumber = shorterNumber;
            shorterNumber = temp;
        }

        while (shorterNumber.size() != longerNumber.size()) {
            shorterNumber.add(0, "0");
        }


        int[] summation = new int[longerNumber.size() + 1];
        int carry = 0;

        for (int i = 0; i < longerNumber.size(); i++) {
            int num1LastDigit = Integer.parseInt(longerNumber.get(longerNumber.size() - i - 1));
            int num2LastDigit = Integer.parseInt(shorterNumber.get(shorterNumber.size() - i - 1));

            int digitSum = num1LastDigit + num2LastDigit + carry;

            if (digitSum / 10 > 0) {
                carry = digitSum / 10;
                summation[i] = digitSum % 10;
                if (i == longerNumber.size() - 1) {
                    summation[i + 1] = carry;
                }
            } else {
                carry = 0;
                summation[i] = digitSum;
            }
        }

        StringBuilder result = new StringBuilder();
        boolean leadingZero = true;
        for (int i = summation.length - 1; i >= 0; i--) {
            if (summation[i] == 0 && leadingZero) {
                continue;
            } else {
                leadingZero = false;
                result.append(summation[i]);
            }

        }

        if(result.length() == 0){
            result.append("0");
        }

        return result.toString();
    }
}
