import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            char[] password = sc.nextLine().toCharArray();
            String hashString = sc.nextLine();
            char[] hash = hashString.toCharArray();

            String sortedPassword = new String(sort(password));

//            for (int j = 0; j < 26; j++) {
//                char currentChar = (char) (j + 97);
//                while(countHashCharacters[j] > countPasswordCharacters[j]){
//                    sortedHash = sortedHash.replaceFirst(String.valueOf(currentChar), "");
//                    countHashCharacters[j] --;
//                }
//            }

            boolean found = false;

            int j = 0;
            while(true){
                int len = j + sortedPassword.length();
                if(len > hashString.length()){
                    break;
                }
                char[] subString = hashString.substring(j, len).toCharArray();
                String sortedHash = new String(sort(subString));
                if(sortedHash.equals(sortedPassword)){
                    System.out.println("YES");
                    found = true;
                    break;
                }

                j++;
            }

            if(!found){
                System.out.println("NO");
            }
        }
    }

    public static char[] sort(char[] characters){
        char[] sorted = new char[characters.length];

        if(characters.length == 0){
            return sorted;
        }

        int[] count = new int[26];

        for (int i = 0; i < characters.length; i++) {
            int character = (int) (characters[i] - 97);
            count[character] += 1;
        }

        int counter = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                sorted[counter] = (char) (i + 97);
                counter++;
            }
        }

        return sorted;
    }
}
