import java.util.Scanner;

public class Fraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int half = n % 2 == 0 ? (n / 2) - 1 : n / 2;

        for (int i = half; i > 0; i--) {
            if(gcd(i, n - i) == 1){
                System.out.println(i + " " + (n - i));
                break;
            }
        }
    }

    static int gcd(int a, int b){
        int mod = a % b;
        if(mod == 0){
            return Math.abs(b);
        }

        return gcd(b, a % b);
    }
}
