package sample;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }


    static boolean isValid(String s) {
        char[] openingBrackets = {'(', '{', '['};
        char[] closingBrackets = {')', '}', ']'};

        char[] input = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        boolean result = true;

        for (int i = 0; i < input.length; i++) {
            if(inArray(openingBrackets, input[i])){
                stack.push(input[i]);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(new String(closingBrackets).indexOf(input[i]) == new String(openingBrackets).indexOf(stack.peek())){
                    stack.pop();
                }else{
                    result = false;
                }
            }
        }

        if(!stack.isEmpty()){
            return false;
        }

        return result;
    }

    static boolean inArray(char[] array, char value){
        boolean result = false;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == value){
                result = true;
                break;
            }
        }

        return result;
    }
}
