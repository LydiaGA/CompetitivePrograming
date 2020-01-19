import java.util.Scanner;

public class PrimeSubtraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            String[] input = sc.nextLine().split(" ");
            long difference = Long.parseLong(input[0]) - Long.parseLong(input[1]);
            if(difference > 1){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
