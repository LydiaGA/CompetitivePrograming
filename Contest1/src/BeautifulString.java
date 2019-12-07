import java.util.Scanner;

public class BeautifulString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            boolean notPossible = false;
            String[] testCase = sc.nextLine().split("");

            for (int j = 0; j < testCase.length; j++) {
                if(j != testCase.length -1 && !testCase[j].equals("?") && testCase[j].equals(testCase[j + 1])){
                    notPossible = true;
                    break;
                }
                if(testCase[j].equals("?")){
                    String toPlace;
                    if(j == testCase.length - 1){
                        toPlace = charToPlace(testCase[j - 1], "");
                    }else if(j == 0){
                        toPlace = charToPlace("", testCase[j + 1]);
                    }else{
                        toPlace = charToPlace(testCase[j - 1], testCase[j + 1]);
                    }

                    if(toPlace.equals("")){
                        notPossible = true;
                        break;
                    }
                    testCase[j] = toPlace;
                }
            }

            if(notPossible){
                System.out.println(-1);
            }else{
                String result = "";
                for (int j = 0; j < testCase.length; j++) {
                    result += testCase[j];
                }
                System.out.println(result);
            }
        }
    }

    static String charToPlace(String left, String right){
        String characters[] = new String[]{"a", "b", "c"};

        String toReturn = "";

        for (String character : characters) {
            if(!character.equals(left) && !character.equals(right)){
                toReturn = character;
                break;
            }
        }
        return toReturn;
    }
}
