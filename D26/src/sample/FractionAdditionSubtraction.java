package sample;

import java.util.ArrayList;

public class FractionAdditionSubtraction {
    public String fractionAddition(String expression) {
        String[] input = expression.split("");
        boolean isNegative = false, isNumerator = true, isTen = false;
        int num;

        ArrayList<Integer> numerators = new ArrayList<>();
        ArrayList<Integer> denominators = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {

            if(input[i].equals("-")){
                isNegative = true;
                continue;
            }

            if(input[i].equals("/")){
                isNumerator = false;
                continue;
            }

            if(input[i].equals("+")){
                continue;
            }

            if(isTen && input[i].equals("0")){
                isTen = false;
                continue;
            }

            num = Integer.parseInt(input[i]);

            if(num == 1 && i != input.length - 1 && input[i + 1].equals("0") ){
                isTen = true;
                num  = 10;
            }else if(num == 1){
                isTen = false;
                num = 1;
            }

            if(isNegative){
                num = -1 * num;
                isNegative = false;
            }

            if(isNumerator){
                numerators.add(num);
            }else{
                denominators.add(num);
                isNumerator = true;
            }
        }

        int denominator = multiply(denominators);
        int numerator = 0;
        for (int i = 0; i < numerators.size(); i++) {
            numerator += (denominator / denominators.get(i)) * numerators.get(i);
        }

        int resultGCD = gcd(numerator, denominator);

        return (numerator / resultGCD) + "/" + (denominator / resultGCD);
    }

    static int gcd(int a, int b){
        int mod = a % b;
        if(mod == 0){
            return Math.abs(b);
        }

        return gcd(b, a % b);
    }

    static int multiply(ArrayList<Integer> nums){
        int result = 1;
        for (int i = 0; i < nums.size(); i++) {
            result *= nums.get(i);
        }

        return result;
    }
}
