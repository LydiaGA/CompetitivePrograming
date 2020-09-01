import java.util.Scanner;

public class TemporarilyUnavailable {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            String[] input = sc.nextLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            int r = Integer.parseInt(input[3]);

            int rBegin = c - r;
            int rEnd = c + r;

            int abMin = Math.min(a, b);
            int abMax = Math.max(a, b);

            int minutes = abMax - abMin;

            if((rBegin <= abMin && abMin <= rEnd) && (rBegin <= abMax && abMax <= rEnd)){
                System.out.println(0);
            }else if(abMin < rBegin && abMax > rEnd){
                System.out.println(minutes - (r * 2));
            }else if(abMax < rBegin || abMin > rEnd){
                System.out.println(minutes);
            }else if(rBegin <= abMax && abMax <= rEnd){
                System.out.println(rBegin - abMin);
            }else if(rBegin <= abMin && abMin <= rEnd){
                System.out.println(abMax - rEnd);
            }
        }
    }
}
