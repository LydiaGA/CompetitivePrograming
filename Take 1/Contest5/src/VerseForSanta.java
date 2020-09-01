import java.util.Scanner;

public class VerseForSanta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            String[] input1 = sc.nextLine().split(" ");
            String[] input2 = sc.nextLine().split(" ");

            int n = Integer.parseInt(input1[0]);
            int s = Integer.parseInt(input1[1]);

            int tempS, inputK, itemCount, maxItems = 0, toRemove = -1;

            for (int j = 0; j <= n; j++) {
                tempS = 0;
                itemCount = 0;

                for (int k = 0; k < n; k++) {
                    inputK = Integer.parseInt(input2[k]);
                    if(k != j){
                        tempS += inputK;
                        if(tempS <= s){
                            itemCount++;
                        }else{
                            break;
                        }
                    }
                }

                if(itemCount > maxItems){
                    maxItems = itemCount;
                    toRemove = j;
                }

                if(j != n && Integer.parseInt(input2[j]) >= s){
                    break;
                }
            }

            if(++toRemove <= n){
                System.out.println(toRemove);
            }else{
                System.out.println(0);
            }

        }
    }
}
