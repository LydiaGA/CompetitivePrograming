import java.util.*;

public class RemoveOneElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] input = sc.nextLine().split(" ");

        int maxLength = 0;

        int currentLength = 0;
        int numberOfRemovedElements = 0;
        for (int i = 0; i < input.length; i++) {

            if (i == input.length - 1){
                if(currentLength > 0){
                    currentLength++;
                    if(currentLength > maxLength){
                        maxLength = currentLength;
                    }
                }
                break;
            }
            int item = Integer.parseInt(input[i]);
            int nextItem = Integer.parseInt((input[i + 1]));
            int previousItem = i == 0 ? -1 : Integer.parseInt(input[i - 1]);
            int nextNextItem = i == input.length - 2 ? -1 : Integer.parseInt(input[i + 2]);

            if(item >= nextItem){
                if(currentLength > 0 && nextItem > previousItem && numberOfRemovedElements == 0){
                    numberOfRemovedElements = 1;
                    continue;
                }else if(currentLength > 0 && item < nextNextItem && numberOfRemovedElements == 0){
                    numberOfRemovedElements = 1;
                    continue;
                }else{
                    currentLength ++;
                    if(currentLength > maxLength){
                        maxLength = currentLength;
                    }
                    currentLength = 0;
                    numberOfRemovedElements = 0;
                    continue;
                }

            }

            currentLength++;
        }

        System.out.println(maxLength);
    }
}
