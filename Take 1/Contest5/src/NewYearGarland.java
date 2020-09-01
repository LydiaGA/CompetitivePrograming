import java.util.Scanner;

public class NewYearGarland {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            String[] input = sc.nextLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int g = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);

            if(!checkIfLessThan(r, new int[]{g,b}) || !checkIfLessThan(g, new int[]{r,b}) || !checkIfLessThan(b, new int[]{g,r})){
                System.out.println("No");
            }else{
                System.out.println("Yes");
            }
        }
    }

    static boolean checkIfLessThan(int toCheck, int[] rest){
        return toCheck <= rest[0] + rest[1] + 1;
    }
}
