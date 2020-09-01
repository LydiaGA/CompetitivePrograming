package sample;

import java.util.Stack;

public class PrefixCalculator {

    public static void main(String[] args) {
        String input = "+ 4 / 12 * 3 4";
        String[] inputArray = input.split(" ");

        Stack<String> stack = new Stack<>();

        for (String s : inputArray) {
            stack.push(s);
        }


        int result = 0;
        int stackSize = stack.size();

        String operator = "";
        int operands[] = new int[2];
        int operandCounter = 0;

        for (int i = 0; i < stackSize; i++) {
            String pop = stack.pop();
            if(isOperator(pop)){
                operator = pop;
                result = doOperation(operator, operands[1], operands[0]);
                operands[0] = result;
                operandCounter = 1;
            }else{
                operands[operandCounter] = Integer.parseInt(pop);
                operandCounter++;
            }
        }

        System.out.println(result);
    }

    static boolean isOperator(String input){
        return input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/");
    }

    static int doOperation(String operator, int operand1, int operand2){
        if(operator.equals("+")){
            return operand1 + operand2;
        }else if(operator.equals("-")){
            return operand1 - operand2;
        }else if(operator.equals("*")){
            return operand1 * operand2;
        }else{
            return operand1 / operand2;
        }
    }
}
