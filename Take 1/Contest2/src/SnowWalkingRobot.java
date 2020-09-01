import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class SnowWalkingRobot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < q; i++) {
            char[] testCase = sc.nextLine().toCharArray();

            StringBuilder sb = new StringBuilder();

            ArrayList<Character> L = new ArrayList<>();
            ArrayList<Character> R = new ArrayList<>();
            ArrayList<Character> U = new ArrayList<>();
            ArrayList<Character> D = new ArrayList<>();

            for (int j = 0; j < testCase.length; j++) {
                if(testCase[j] == 'L'){
                    L.add(testCase[j]);
                }else if(testCase[j] == 'R'){
                    R.add(testCase[j]);
                }else if(testCase[j] == 'U'){
                    U.add(testCase[j]);
                }else if(testCase[j] == 'D'){
                    D.add(testCase[j]);
                }
            }

            ArrayList<Character> longerHor = L;
            ArrayList<Character> shorterHor = R;
            ArrayList<Character> longerVer = U;
            ArrayList<Character> shorterVer = D;

            if(R.size() > L.size()){
                longerHor = R;
                shorterHor = L;
            }

            if(D.size() > U.size()){
                longerVer = D;
                shorterVer = U;
            }

            while(longerHor.size() > shorterHor.size()){
                longerHor.remove(longerHor.size() - 1);
            }

            while(longerVer.size() > shorterVer.size()){
                longerVer.remove(longerVer.size() - 1);
            }

            if(longerVer.size() == 0 && longerHor.size() != 0){
                sb.append("LR");
            }else if(longerHor.size() == 0 && longerVer.size() != 0){
                sb.append("DU");
            }else{
                for (char l : L) {
                    sb.append(l);
                }

                for (char u : U) {
                    sb.append(u);
                }

                for (char r : R) {
                    sb.append(r);
                }

                for (char d : D) {
                    sb.append(d);
                }
            }

            System.out.println(sb.length());
            System.out.println(sb.toString());
        }
    }


}
