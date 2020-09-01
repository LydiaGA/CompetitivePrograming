package sample;

import java.util.Arrays;

public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }


    public static int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        Arrays.fill(prime,true);
        prime[0] = false;
        prime[1] = false;
        int m = (int) Math.sqrt(n);

        int count = n - 2;

        for (int i=2; i<=m; i++) {
            if (prime[i]) {
                for (int k=i*i; k<n; k+=i) {
                    count--;
                    prime[k] = false;
                }
            }
        }
        return count;
    }
}
