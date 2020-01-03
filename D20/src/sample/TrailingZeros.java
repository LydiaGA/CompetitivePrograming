package sample;

public class TrailingZeros {
    public static void main(String[] args) {

    }
    public int trailingZeroes(int n) {
        int zeros = 0;
        int i = 1;
        while(Math.pow(5, i) <= n){
            zeros += n / Math.pow(5, i);
            i++;
        }

        return zeros;
    }
}
