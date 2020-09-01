import java.util.Arrays;
import java.util.Scanner;

public class BeautifulNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(sc.nextLine());
            String[] permutation = sc.nextLine().split(" ");

            StringBuilder result = new StringBuilder();
            int l, r;
            String isBeautiful;

            int[] sorted = sort(permutation);

            for (int j = 0; j < sorted.length; j++) {
                int permutationJ = sorted[j];
                l = Arrays.asList(permutation).indexOf(sorted[j] + "");
                r = Arrays.asList(permutation).indexOf(sorted[j] + "");

                for (int k = 0; k < permutation.length; k++) {
                    int permutationK = Integer.parseInt(permutation[k]);
                    if(k < l && permutationK <= permutationJ){
                        l = k;
                    }else if(k > l && permutationK <= permutationJ){
                        r = k;
                    }
                }

                isBeautiful = "1";
                for (int k = l; k < r; k++) {
                    if(Integer.parseInt(permutation[k]) > permutationJ){
                        isBeautiful = "0";
                    }
                }

                result.append(isBeautiful);
            }

            System.out.println(result.toString());

        }
    }

    public static int[] sort(String[] nums){
        int[] sorted = new int[nums.length];

        if(nums.length == 0){
            return sorted;
        }

        int max = getMax(nums);

        int[] count = new int[max + 1];

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
