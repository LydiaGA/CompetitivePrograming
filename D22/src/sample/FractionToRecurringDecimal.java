package sample;

import java.util.*;

public class FractionToRecurringDecimal {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 900));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        int n = numerator;
        StringBuilder result = new StringBuilder();
        boolean inDecimal = false, isSmaller = false, isRepeating = false;
        Set<Integer> remainders = new HashSet<>();
        remainders.add(numerator);
        while(n != 0){
            if(n >= denominator){
                isSmaller = false;
            }else{
                if(isSmaller){
                    result.append("0");
                    remainders.add(n);
                }
                if (!inDecimal){
                    if(result.toString().equals("")){
                        result.append("0");
                    }
                    result.append(".");
                    inDecimal = true;
                }
                n = n * 10;
                isSmaller = true;
                if(isRepeating){
                    break;
                }
                continue;
            }
            if(isRepeating){
                break;
            }
            result.append(n / denominator);
            n = n % denominator;

            if(remainders.contains(n)){
                isRepeating = true;
            }
            remainders.add(n);

        }


        if(isRepeating){
            int point = result.indexOf(".");
            String afterPoint = result.substring(point);
            int bracketStart = afterPoint.indexOf(n / denominator + "");
            result.insert(bracketStart + point, "(");
            result.append(")");
        }

        return result.toString();
    }
}
