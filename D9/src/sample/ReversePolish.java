package sample;

import java.util.*;

public class ReversePolish {
    public static void main(String[] args) {
        String[] inputArray = new String[]{"10"};

        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, inputArray);

        int result = Integer.parseInt(queue.peek());
        int queueSize = queue.size();

        String operator = "";
        ArrayList<Integer> operands = new ArrayList<>();

        for (int i = 0; i < queueSize; i++) {
            String pop = queue.remove();
            if(isOperator(pop)){
                operator = pop;
                result = doOperation(operator, operands.get(operands.size() - 2), operands.get(operands.size() - 1));
                operands.remove(operands.size() - 1);
                operands.remove(operands.size() - 1);
                operands.add(result);
            }else{
                operands.add(Integer.parseInt(pop));
            }
        }

        System.out.println(result);
    }

    static boolean isOperator(String input){
        return input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/");
    }

    static int doOperation(String operator, int operand1, int operand2){
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            default:
                return operand1 / operand2;
        }
    }

}
