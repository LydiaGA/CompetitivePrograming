package main;

import java.util.Stack;

public class ValidateStack {

    public static void main(String[] args) {
	// write your code here
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length == 0){
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 1;
        stack.push(pushed[0]);
        while(i < popped.length){
            if(stack.isEmpty()){
                stack.push(pushed[j]);
                j++;
            }
            if(stack.peek() == popped[i]){
                stack.pop();
                i++;
            }else{
                if(j < pushed.length){
                    stack.push(pushed[j]);
                    j++;
                }else{
                    return false;
                }
            }
        }

        return true;
    }
}
