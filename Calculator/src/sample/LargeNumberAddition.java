package sample;

import java.util.ArrayList;
import java.util.Arrays;

public class LargeNumberAddition {
    public String add(String number1, String number2) {

        boolean negative = false, num1Negative = false, num2Negative = false;
        LargeNumberSubtraction subtractor = new LargeNumberSubtraction();

        if(number1.charAt(0) == '-' && number2.charAt(0) == '-'){
            negative = true;
            number1 = number1.substring(1);
            number2 = number2.substring(1);
        }else if(number1.charAt(0) == '-'){
            num1Negative = true;
            number1 = number1.substring(1);
        }else if(number2.charAt(0) == '-'){
            num2Negative = true;
            number2 = number2.substring(1);
        }

        ArrayList<String> longerNumber = new ArrayList<String>(Arrays.asList(number1.split("")));
        ArrayList<String> shorterNumber = new ArrayList<String>(Arrays.asList(number2.split("")));

        if (number2.equals(getLarger(number1, number2))) {
            ArrayList<String> temp = longerNumber;
            longerNumber = shorterNumber;
            shorterNumber = temp;
            if(num2Negative){
                String difference = subtractor.subtract(number2, number1);
                return "-" + difference;
            }else if(num1Negative){
                return subtractor.subtract(number2, number1);
            }
        }else{
            if(num1Negative){
                String difference = subtractor.subtract(number1, number2);
                return "-" + difference;
            }else if(num2Negative){
                return subtractor.subtract(number1, number2);
            }
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

        if(negative){
            return "-" + result.toString();
        }else {
            return result.toString();
        }
    }

    String getLarger(String number1, String number2){
        if(number1.length() > number2.length()){
            return number1;
        }else if(number2.length() > number1.length()){
            return number2;
        }else{
            String larger = number1;
            for (int i = 0; i < number1.length(); i++) {
                if(number1.charAt(i) > number2.charAt(i)){
                    larger =  number1;
                    break;
                }else if(number2.charAt(i) > number1.charAt(i)){
                    larger = number2;
                    break;
                }
            }
            return larger;
        }
    }

    public static void main(String[] args) {
        LargeNumberAddition adder = new LargeNumberAddition();
        System.out.println(adder.add("03", "000"));
    }
}
