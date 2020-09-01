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
        if(n == 2){
            return x * x;
        }else if(n == 1){
            return x;
        }else if(n == 0) {
            return 1;
        }else{
            double tempPow = getPow(x, n / 2);
            return tempPow * tempPow;
        }
    }

}
