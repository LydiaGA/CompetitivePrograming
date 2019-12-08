package sample;

import java.util.ArrayList;
import java.util.Arrays;

public class LargeNumberSubtraction {
    public String subtract(String number1, String number2){

        boolean negative = false;
        LargeNumberAddition adder = new LargeNumberAddition();
        if(number1.charAt(0) == '-' && number2.charAt(0) == '-'){
           return adder.add(number1, number2.substring(1));
        }else if(number1.charAt(0) == '-'){
            return adder.add(number1, "-" + number2);
        }else if(number2.charAt(0) == '-'){
           return adder.add(number1, number2.substring(1));
        }

        ArrayList<String> longerNumber = new ArrayList<String>(Arrays.asList(number1.split("")));
        ArrayList<String> shorterNumber = new ArrayList<String>(Arrays.asList(number2.split("")));


        if (number2.equals(getLarger(number1, number2))) {
            negative = true;
            ArrayList<String> temp = longerNumber;
            longerNumber = shorterNumber;
            shorterNumber = temp;
        }else if("".equals(getLarger(number1, number2))){
            return "0";
        }

        while (shorterNumber.size() != longerNumber.size()) {
            shorterNumber.add(0, "0");
        }

        int[] differences = new int[longerNumber.size() + 1];
        int borrow = 0;

        for (int i = 0; i < longerNumber.size(); i++) {
            int num1LastDigit = Integer.parseInt(longerNumber.get(longerNumber.size() - i - 1));
            int num2LastDigit = Integer.parseInt(shorterNumber.get(shorterNumber.size() - i - 1));

            int digitDifference = 0;
            num1LastDigit -= borrow;

            if (num1LastDigit >= num2LastDigit) {
                digitDifference = num1LastDigit - num2LastDigit;
                borrow = 0;
            } else {
                num1LastDigit += 10;
                borrow = 1;
                digitDifference = num1LastDigit - num2LastDigit;
            }

//            System.out.println(borrow);
//            System.out.println(digitDifference);

            differences[i] = digitDifference;
        }

        StringBuilder result = new StringBuilder();
        boolean leadingZero = true;
        for (int i = differences.length - 1; i >= 0; i--) {
            if (differences[i] == 0 && leadingZero) {
                continue;
            } else {
                leadingZero = false;
                result.append(differences[i]);
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
            String larger = "";
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
        LargeNumberSubtraction subtrator = new LargeNumberSubtraction();
        System.out.println(subtrator.subtract("40", "40"));
    }
}
