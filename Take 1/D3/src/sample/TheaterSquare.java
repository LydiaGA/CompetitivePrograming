import java.util.Scanner;

public class TheaterSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long a = sc.nextLong();

        long rowTiles = n % a > 0 ? (n / a) + 1 : n / a;
        long columnTiles = m % a > 0 ? (m / a) + 1 : m / a;

        long tiles = rowTiles * columnTiles;
        System.out.println(tiles);
    }
}
