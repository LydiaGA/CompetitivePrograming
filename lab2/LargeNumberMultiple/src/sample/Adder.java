package sample;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Adder {
    public ArrayList<Integer> add(ArrayList<Integer> number1, ArrayList<Integer> number2){
        ArrayList<Integer> longerNumber = number1;
        ArrayList<Integer> shorterNumber = number2;

        if(number2.size() > number1.size()){
            longerNumber = number2;
            shorterNumber = number1;
        }

        while(shorterNumber.size() != longerNumber.size()){
            shorterNumber.add(0, 0);
        }


        int summation[] = new int[longerNumber.size() + 1];
        ArrayList<Integer> result = new ArrayList<>();
        int carry = 0;

        System.out.println(longerNumber);
        System.out.println(shorterNumber);

        for (int i = 0; i < longerNumber.size(); i++) {
            int num1LastDigit = longerNumber.get(number1.size() - i - 1);
            int num2LastDigit = shorterNumber.get(number2.size() - i - 1);

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

        for (int i = summation.length - 1; i >= 0; i--) {
            result.add(summation[i]);
        }

        return result;
    }
}
