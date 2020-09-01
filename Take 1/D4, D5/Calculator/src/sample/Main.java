package sample;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String input = sc.nextLine();
            if(input.equals("exit")){
                break;
            }
            String[] inputArray = input.split(" ");
            if(inputArray[1].equals("+")){
                LargeNumberAddition adder = new LargeNumberAddition();
                System.out.println("Result: " + adder.add(inputArray[0], inputArray[2]));
            }else if(inputArray[1].equals("-")){
                LargeNumberSubtraction subtractor = new LargeNumberSubtraction();
                System.out.println("Result: " + subtractor.subtract(inputArray[0], inputArray[2]));
            }else if(inputArray[1].equals("*")){
                LargeNumberMultiplication multiplier = new LargeNumberMultiplication();
                System.out.println("Result: " + multiplier.multiply(inputArray[0], inputArray[2]));
            }else if(inputArray[1].equals("/")){
                LargeNumberDivision divider = new LargeNumberDivision();
                System.out.println("Result: " + divider.divide(inputArray[0], inputArray[2]));
            }
        }

    }
}
