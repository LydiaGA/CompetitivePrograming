package sample;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String number1 = "222";
        String number2 = "777";

        ArrayList<ArrayList<Integer>> tempMultiples = new ArrayList<java.util.ArrayList<Integer>>();

        for (int i = 0; i < number1.length(); i++){
            ArrayList<Integer> tempMultiple = new ArrayList<Integer>();
            int carry = 0;
            for (int k = 0; k < i; k++) {
                tempMultiple.add(0);
            }
            for (int j = 0; j < number2.length(); j++){
                int digitMultiple = Integer.parseInt(String.valueOf(number1.charAt(i))) * Integer.parseInt(String.valueOf(number2.charAt(j))) + carry;
                //System.out.println(digitMultiple / 10);
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
           // System.out.println(result);
           // System.out.println(invert(tempMultiples.get(i)));
            result = adder.add(result, invert(tempMultiples.get(i)));
        }

        System.out.println(tempMultiples);
        System.out.println(result);
    }

    public static ArrayList<Integer> invert(ArrayList<Integer> input){
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int i = input.size() - 1; i >= 0; i--) {
            output.add(input.get(i));
        }

        return output;
    }
}
