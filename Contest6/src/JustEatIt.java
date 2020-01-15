import java.util.Scanner;

public class JustEatIt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        String result = "YES";
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(sc.nextLine());
            String[] input = sc.nextLine().split(" ");

            for (int j = 0; j < input.length; j++) {
                int inputJ = Integer.parseInt(input[j]);
                if(inputJ <= 0){
                    result = "NO";
                    break;
                }
            }

            System.out.println(result);
        }
    }
}
