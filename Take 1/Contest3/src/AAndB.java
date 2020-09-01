import java.util.Scanner;

public class AAndB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            String[] nums = sc.nextLine().split(" ");
            int num1 = Integer.parseInt(nums[0]);
            int num2 = Integer.parseInt(nums[1]);

            if(num1 == num2){
                System.out.println(0);
                continue;
            }

            int difference = Math.abs(num1 - num2);
            int[] sumResult = sum(difference);
            int numberOfOperations = sumResult[0];
            int sum = sumResult[1];

            if(sum == difference){
                System.out.println(numberOfOperations);
                continue;
            }else{
                System.out.println("sdg");
            }


        }
        
    }
    
    static int[] sum(int n){
        int sum = 0;

        int i = 1;
        while(sum < n){
            sum += i;
            i++;
        }

        return new int[]{i - 1, sum};
    }
}
