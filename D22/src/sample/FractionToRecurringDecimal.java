package sample;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FractionToRecurringDecimal {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 900));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        int n = numerator, decimalCounter = 0, firstRepeating = -1;
        StringBuilder result = new StringBuilder();
        boolean inDecimal = false, isSmaller = false, isRepeating = false;
        Map<Integer, Integer> remainders = new HashMap<>();
        remainders.put(numerator, decimalCounter);
        while(n != 0 && !isRepeating){
            if(n >= denominator){
                isSmaller = false;
            }else{
                if(isSmaller){
                    result.append("0");
                    remainders.put(n, decimalCounter);
                    decimalCounter++;
                }
                if (!inDecimal){
                    if(result.toString().equals("")){
                        result.append("0");
                        decimalCounter++;
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
            decimalCounter++;

            if(remainders.containsKey(n)){
                isRepeating = true;
                firstRepeating = remainders.get(n);
            }
            System.out.println(remainders.toString());
            System.out.println(firstRepeating + "*");
            System.out.println(n + "n");
            remainders.put(n, decimalCounter);
        }


        if(isRepeating){
            System.out.println(firstRepeating);
            int point = result.indexOf(".") + 1;
            int bracketStart = firstRepeating > 1 ? firstRepeating + 1: firstRepeating + point;
            result.insert(bracketStart, "(");
            result.append(")");
        }

        return result.toString();
    }
}
