import java.util.Scanner;

public class ErasingZeroes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            String input = sc.nextLine();

            boolean foundInitial1 = false;
            boolean foundZero = false;
            int count = 0;
            int tempCount = 0;
            for (int j = 0; j < input.length(); j++) {

                if(!foundInitial1 && input.charAt(j) == '1'){
                    foundInitial1 = true;
                }else if(foundInitial1 && input.charAt(j) == '0'){
                    foundZero = true;
                    tempCount++;
                }else if(foundInitial1 && foundZero && input.charAt(j) == '1'){
                    count += tempCount;
                    foundZero = false;
                    tempCount = 0;
                }
            }

            System.out.println(count);
        }
    }
}
