import java.util.ArrayList;
import java.util.Scanner;

public class BrokenKeyboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] line1 = sc.nextLine().split(" ");

        String[] input = sc.nextLine().split("");
        String[] workingKeys = sc.nextLine().split(" ");

        ArrayList<String> subStrings = new ArrayList<>();
        StringBuilder subString = new StringBuilder();

        for (int i = 0; i < input.length; i++) {
            if(checkIfBroken(workingKeys, input[i])){
                subStrings.add(subString.toString());
                subString = new StringBuilder();
                continue;
            }
            subString.append(input[i]);
        }
        subStrings.add(subString.toString());

        long combinationSum = 0;

        for (String item : subStrings) {
            long n = item.length();
            long numberOfSubstrings = (n * (n + 1)) / 2;
            combinationSum += numberOfSubstrings;
        }

        System.out.println(combinationSum);
    }

    private static boolean checkIfBroken(String[] workingKeys, String letter){
        boolean isBroken = true;
        for (int i = 0; i < workingKeys.length; i++) {
            if(workingKeys[i].equals(letter)){
                isBroken = false;
                break;
            }
        }

        return isBroken;
    }
}
