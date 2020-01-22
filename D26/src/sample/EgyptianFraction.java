package sample;

import java.util.ArrayList;

public class EgyptianFraction {
    public static void main(String[] args) {
        System.out.println(egyptianFraction("5/6"));
    }

    public static ArrayList<String> egyptianFraction(String n){
        ArrayList<String> result = new ArrayList<>();
        int numerator, denominator;
        String tempResult = "";
        FractionAdditionSubtraction addSub = new FractionAdditionSubtraction();
        while(true){
            numerator = Integer.parseInt(n.split("/")[0]);
            denominator = Integer.parseInt(n.split("/")[1]);
            if (numerator == 1){
                result.add(numerator + "/" + denominator);
                break;
            }

            tempResult = "1/" + (int) Math.ceil((float)denominator / numerator);
            result.add(tempResult);

            n = addSub.fractionAddition(n + "-" + tempResult);
        }

        return result;
    }
}
