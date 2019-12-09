package sample;

public class ReorganizeString {

    public static void main(String[] args) {
        System.out.println(reorganizeString("mmmlo"));
    }

    public static String reorganizeString(String s){
        char[] sorted = sort(s.toCharArray());
        char[] reorganized = new char[s.toCharArray().length];
        boolean isPlaced;

        for (int i = 0; i < reorganized.length; i++) {
            if(i == 0){
                reorganized[i] = sorted[0];
                sorted[0] = 0;
                continue;
            }
            isPlaced = false;
            for (int j = 0; j < sorted.length; j++) {
                if(reorganized[i-1] != sorted[j] && sorted[j] != 0){
                    reorganized[i] = sorted[j];
                    sorted[j] = 0;
                    isPlaced = true;
                    break;
                }
            }

            if(!isPlaced){
                return "";
            }
        }

        return new String(reorganized);
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
