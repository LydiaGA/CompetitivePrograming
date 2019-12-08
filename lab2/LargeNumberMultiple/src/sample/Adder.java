package sample;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Adder {
    public String add(String number1, String number2){
        ArrayList<String> longerNumber = new ArrayList<String>(Arrays.asList(number1.split("")));
        ArrayList<String> shorterNumber = new ArrayList<String>(Arrays.asList(number2.split("")));

        if(number2.length() > number1.length()){
            ArrayList<String> temp = longerNumber;
            longerNumber = shorterNumber;
            shorterNumber = temp;
        }

        while(shorterNumber.size() != longerNumber.size()){
            shorterNumber.add(0, "0");
        }


        int[] summation = new int[longerNumber.size() + 1];
        int carry = 0;

        for (int i = 0; i < longerNumber.size(); i++) {
            int num1LastDigit = Integer.parseInt(longerNumber.get(longerNumber.size() - i - 1));
            int num2LastDigit = Integer.parseInt(shorterNumber.get(shorterNumber.size() - i - 1));

            int digitSum = num1LastDigit + num2LastDigit + carry;

            if(digitSum / 10 > 0){
                carry = digitSum / 10;
                summation[i] = digitSum % 10;
                if(i == longerNumber.size() - 1){
                    summation[i + 1] = carry;
                }
            }else{
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

        return result.toString();
    }

//    public ArrayList<Integer> add(ArrayList<Integer> number1, ArrayList<Integer> number2){
//        StringBuilder sb = new StringBuilder();
//        for (int s : number1)
//        {
//            sb.append(s);
//        }
//
//        StringBuilder sb2 = new StringBuilder();
//        for (int s : number2)
//        {
//            sb2.append(s);
//        }
//
//        //System.out.println(sb.toString() + " " + sb2.toString());
//        return add(sb.toString(), sb2.toString());
//    }

    public static void main(String[] args) {
        Adder adder = new Adder();
        System.out.println(adder.add("2342345", "354563456"));
    }
}
