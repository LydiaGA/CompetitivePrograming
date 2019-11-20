import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int weight = Integer.parseInt(sc.nextLine());

        if(weight == 2){
            System.out.println("NO");
        }else if(weight % 2 == 0){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
