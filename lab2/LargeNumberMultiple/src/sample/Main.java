package sample;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String number1 = "-222";
        String number2 = "-777";

        boolean negative = false;
        if(number1.charAt(0) == '-' && number2.charAt(0) == '-'){
            negative = false;
            number1 = number1.substring(1, number1.length());
            number2 = number2.substring(1, number2.length());
        }else if(number1.charAt(0) == '-'){
            negative = true;
            number1 = number1.substring(1, number1.length());
        }else if(number2.charAt(0) == '-'){
            negative = true;
            number2 = number2.substring(1, number2.length());
        }

        ArrayList<ArrayList<Integer>> tempMultiples = new ArrayList<java.util.ArrayList<Integer>>();

        for (int i = 0; i < number1.length(); i++){
            ArrayList<Integer> tempMultiple = new ArrayList<Integer>();
            int carry = 0;
            for (int k = 0; k < i; k++) {
                tempMultiple.add(0);
            }
            for (int j = 0; j < number2.length(); j++){
                int digitMultiple = Integer.parseInt(String.valueOf(number1.charAt(i))) * Integer.parseInt(String.valueOf(number2.charAt(j))) + carry;

                if(digitMultiple / 10 > 0){
                    carry = digitMultiple / 10;
                }else{
                    carry = 0;
                }
                tempMultiple.add(digitMultiple % 10);
                if(j < number2.length() - 1){
                   continue;
                }else{
                    tempMultiple.add(digitMultiple / 10);
                }

            }
            tempMultiples.add(tempMultiple);
        }

        ArrayList<Integer> result = invert((ArrayList<Integer>) tempMultiples.get(0).clone());
        Adder adder = new Adder();
        for (int i = 1; i < tempMultiples.size(); i++) {
            result = adder.add(result, invert(tempMultiples.get(i)));
        }

        boolean leadingZero = true;
        String multiple;
        if (negative){
            multiple = "-";
        }else{
            multiple = "";
        }
        for (int i = 0; i < result.size(); i++) {
                if(result.get(0) == 0 && leadingZero){
                    result.remove(i);
                }
                multiple += result.get(i);
        }

        System.out.println(multiple);
    }

    public static ArrayList<Integer> invert(ArrayList<Integer> input){
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int i = input.size() - 1; i >= 0; i--) {
            output.add(input.get(i));
        }

        return output;
    }
}
