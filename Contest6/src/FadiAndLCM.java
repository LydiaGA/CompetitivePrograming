import java.util.Scanner;

public class FadiAndLCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = Long.parseLong(sc.nextLine());
        long sqrt = (int) Math.sqrt(x);

        String result = "";
        for (long i = sqrt; i > 0; i--) {
            long divider = x / i;
            if(x % i != 0){
                continue;
            }
            if(lcm(i, divider) == x){
                result = i + " " + divider;
                break;
            }
        }

        System.out.println(result);
    }

    static long lcm(long a, long b){
        return (a * b) / gcd(a, b);
    }

    static long gcd(long a, long b){
        long mod = a % b;
        if(mod == 0){
            return Math.abs(b);
        }

        return gcd(b, a % b);
    }
}
