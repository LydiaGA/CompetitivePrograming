package Week2;

public class RecursiveDigitSum {
    int superDigit(String n, int k) {
        return Integer.parseInt(doSuperDigit(n, k));
    }

    String doSuperDigit(String input, int k){
        long sum = 0;
        for(int i = 0; i < input.length(); i++){
            sum += Character.getNumericValue(input.charAt(i));
        }

        String result = String.valueOf(sum * k);
        if(result.length() == 1){
            return result;
        }

        return doSuperDigit(result, 1);
    }

}
