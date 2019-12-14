import java.util.Scanner;

public class ThreeFriends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < q; i++) {
            String[] testCase = sc.nextLine().split(" ");
            int[] sorted = sort(new int[]{Integer.parseInt(testCase[0]), Integer.parseInt(testCase[1]), Integer.parseInt(testCase[2])});
            int a = sorted[0], b = sorted[1], c = sorted[2];

            if(sorted[0] < sorted[1] && sorted[1] < sorted[2]){
                a = sorted[0] + 1;
                c = sorted[2] - 1;
            }else if(sorted[0] == sorted[1] && sorted[1] != sorted[2]){
                if(sorted[2] == sorted[1] + 1){
                    c = sorted[2] - 1;
                }else{
                    a = sorted[0] + 1;
                    b = sorted[1] + 1;
                    c = sorted[2] - 1;
                }
            }else if(sorted[1] == sorted[2] && sorted[0] != sorted[1]){
                if(sorted[0] == sorted[1] - 1){
                    a = sorted[0] + 1;
                }else {
                    a = sorted[0] + 1;
                    b = sorted[1] - 1;
                    c = sorted[2] - 1;
                }
            }

            System.out.println(Math.abs(a - b) + Math.abs(b - c) + Math.abs(a - c));

        }
    }

    public static int[] sort(int[] input){
        for (int i = 0; i < input.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < input.length; j++) {
                if(input[minIndex] > input[j]){
                    minIndex = j;
                }
            }

            int temp = input[i];
            input[i] = input[minIndex];
            input[minIndex] = temp;

        }

        return input;
    }
}
