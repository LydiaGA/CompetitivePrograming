import java.util.Scanner;

public class FindDivisible {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            String[] input = sc.nextLine().split(" ");
            int l = Integer.parseInt(input[0]);
            int r = Integer.parseInt(input[1]);
            boolean found = false;
            for (int j = l; j <= r; j++) {
                if(found){
                    break;
                }
                for (int k = 2; k <= r; k++) {
                    if((j * k) <= r){
                        System.out.println(j + " " + j * k);
                        found = true;
                        break;
                    }
                }
            }


        }
    }
}
