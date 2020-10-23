package Week6;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int removed = 0;
        for(int i = 0; i < num.length(); i++){
            char current = num.charAt(i);
            if(stack.isEmpty() || current >= stack.peek()){
                stack.push(current);
            }else{
                while(!stack.isEmpty() && current < stack.peek() && removed < k){
                    stack.pop();
                    removed++;
                }
                stack.push(current);
            }
        }


        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            if(stack.size() > num.length() - k){
                stack.pop();
            }else{
                sb.insert(0, stack.pop());
            }
        }

        while(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        if(sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }
}
