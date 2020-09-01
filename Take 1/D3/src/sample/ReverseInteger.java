package sample;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

    public static int reverse(int x) {
        long result = 0;
        boolean negative = false;

        if(x < 0){
            negative = true;
            x *= -1;
        }

        while(x > 0){
            if(result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10){
                return 0;
            }
            result = result * 10 + (x % 10);
            x = x / 10;
        }

        if(negative){
            result *= -1;
        }

        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE){
            return 0;
        }

        return (int) result;

    }
}
