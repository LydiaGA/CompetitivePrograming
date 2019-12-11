import java.util.Scanner;

public class BeautifulString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            boolean notPossible = false;
            char[] testCase = sc.nextLine().toCharArray();

            for (int j = 0; j < testCase.length; j++) {
                if(j != testCase.length -1 && testCase[j] != '?' && testCase[j] == testCase[j + 1]){
                    notPossible = true;
                    break;
                }
                if(testCase[j] == '?'){
                    char toPlace;
                    if(testCase.length == 1){
                        toPlace = charToPlace(' ', ' ');
                    }else if (j == 0) {
                        toPlace = charToPlace(' ', testCase[j + 1]);
                    }else if(j == testCase.length - 1){
                        toPlace = charToPlace(testCase[j - 1], ' ');
                    }else{
                        toPlace = charToPlace(testCase[j - 1], testCase[j + 1]);
                    }

                    if(toPlace == ' '){
                        notPossible = true;
                        break;
                    }
                    testCase[j] = toPlace;
                }
            }

            if(notPossible){
                System.out.println(-1);
            }else{
                System.out.println(new String(testCase));
            }
        }
    }

    static char charToPlace(char left, char right){
        char[] characters = new char[]{'a', 'b', 'c'};

        char toReturn = ' ';

        for (char character : characters) {
            if(character != left && character != right){
                toReturn = character;
                break;
            }
        }
        return toReturn;
    }
}
