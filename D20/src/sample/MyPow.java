package sample;

public class MyPow {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 214));
    }

    public static double myPow(double x, int n) {
        if(n < 0){
            return 1 / getPow(x, Math.abs(n));
        }else{
            return getPow(x, n);
        }
    }

    public static double getPow(double x, int n) {
        double pow = 1;
        if(n <= 2){
            for (int i = 0; i < n; i++) {
                pow *= x;
            }
            return pow;
        }else{
            double tempPow = getPow(x, n / 2);
            return tempPow * tempPow;
        }
    }
}
