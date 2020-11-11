package Week3;

public class DivideTwoNumbers {
    public int divide(int dividend, int divisor) {
        boolean isNegative = false;
        long newDividend = dividend;
        long newDivisor = divisor;
        if(dividend < 0 && divisor < 0){
            newDividend *= -1;
            newDivisor *= -1;
        }else if(dividend < 0){
            newDividend *= -1;
            isNegative = true;
        }else if(divisor < 0){
            newDivisor *= -1;
            isNegative = true;
        }

        if(newDivisor == 1){
            long result = isNegative ? newDividend * -1 : newDividend;
            if(result > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else{
                return (int)result;
            }
        }

        int result = 0;
        while(newDividend >= 0){
            newDividend -= newDivisor;
            result += 1;
        }

        result -= 1;
        return isNegative ? (result * -1) : result;
    }
}
