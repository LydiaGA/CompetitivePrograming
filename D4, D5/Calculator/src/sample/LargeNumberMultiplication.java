package sample;

import java.util.ArrayList;

public class LargeNumberMultiplication {
    public String multiply(String number1, String number2){

        boolean negative = false;
        if(number1.charAt(0) == '-' && number2.charAt(0) == '-'){
            negative = false;
            number1 = number1.substring(1);
            number2 = number2.substring(1);
        }else if(number1.charAt(0) == '-'){
            negative = true;
            number1 = number1.substring(1);
        }else if(number2.charAt(0) == '-'){
            negative = true;
            number2 = number2.substring(1);
        }

        ArrayList<ArrayList<Integer>> tempMultiples = new ArrayList<>();

        for (int i = 0; i < number1.length(); i++){
            ArrayList<Integer> tempMultiple = new ArrayList<Integer>();
            int carry = 0;
            for (int k = 0; k < i; k++) {
                tempMultiple.add(0);
            }
            for (int j = 0; j < number2.length(); j++){
                int digitMultiple = Integer.parseInt(String.valueOf(number1.charAt(number1.length() - i - 1))) * Integer.parseInt(String.valueOf(number2.charAt(number2.length() - j - 1))) + carry;

                if(digitMultiple / 10 > 0){
                    carry = digitMultiple / 10;
                }else{
                    carry = 0;
                }
                tempMultiple.add(digitMultiple % 10);
                if(j < number2.length() - 1){
                    continue;
                }else{
                    if(digitMultiple / 10 != 0){
                        tempMultiple.add(digitMultiple / 10);
                    }
                }

            }
            tempMultiples.add(tempMultiple);
        }

        String result = invert((ArrayList<Integer>) tempMultiples.get(0).clone());
        LargeNumberAddition adder = new LargeNumberAddition();
        for (int i = 1; i < tempMultiples.size(); i++) {
            result = adder.add(result, invert(tempMultiples.get(i)));
        }

        if (negative){
            return "-" + result;
        }else{
            return result;
        }

    }

     static String invert(ArrayList<Integer> input){
        StringBuilder result = new StringBuilder();
        for (int i = input.size() - 1; i >= 0; i--) {
            result.append(input.get(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        LargeNumberMultiplication multiplier = new LargeNumberMultiplication();
        System.out.println(multiplier.multiply("0", "3"));
    }
}
