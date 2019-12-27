import java.util.ArrayList;
import java.util.Scanner;

public class KForOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            String[] input1 = sc.nextLine().split(" ");
            String[] input2 = sc.nextLine().split(" ");

            if(Integer.parseInt(input1[0]) == 0){
                System.out.println(0);
                continue;
            }
            int c;
            int[] sorted = sort(input2);

            int boughtItems = 0;
            for (int j = sorted.length - 1; j >= 0; j--) {
                c = Integer.parseInt(input1[1]);
                int temp = 0;
                if(j == 0 && sorted[j] <= c){
                    if(boughtItems < 1){
                        boughtItems = 1;
                    }
                    continue;
                }else if(sorted[j] <= c){
                    temp += 2;
                    c -= sorted[j];
                }else{
                    continue;
                }

                for (int k = 0; k < j - 1; k++) {
                    if(sorted[k] <= c){
                        temp++;
                        c -= sorted[k];
                    }
                }

                if(temp > boughtItems){
                    boughtItems = temp;
                }
            }

            System.out.println(boughtItems);
        }
    }

    static int[] sort(String[] nums){
        if(nums.length == 0){
            return new int[]{};
        }

        int max = getMax(nums);

        int[] count = new int[max + 1];

        int[] sorted = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            count[Integer.parseInt(nums[i])] += 1;
        }

        int counter = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                sorted[counter] = i;
                counter++;
            }
        }

        return sorted;
    }

    static int getMax(String[] array){
        int max = Integer.parseInt(array[0]);
        for (int i = 1; i < array.length; i++) {
            if(Integer.parseInt(array[i]) > max){
                max = Integer.parseInt(array[i]);
            }
        }

        return max;
    }
}
