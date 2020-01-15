package sample;

import java.util.HashSet;
import java.util.Set;

public class FractionToRecurringDecimal {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(5, 1000));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        int n = numerator;
        StringBuilder result = new StringBuilder();
        boolean inDecimal = false, isSmaller = false, isRepeating = false;
        Set<Integer> remainders = new HashSet<>();
        remainders.add(numerator);
        while(n != 0 && !isRepeating){
            if(n >= denominator){
                isSmaller = false;
            }else{
                if(isSmaller){
                    result.append("0");
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
                continue;
            }
            result.append(n / denominator);
            n = n % denominator;
            if(remainders.contains(n)){
                isRepeating = true;
            }
            remainders.add(n);
        }


//        if(isRepeating){
//           result.
//        }


        return result.toString();
    }
}
