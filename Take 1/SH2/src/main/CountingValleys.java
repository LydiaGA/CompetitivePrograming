package main;

import java.util.Stack;

public class CountingValleys {
    static int countingValleys(int n, String s) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int altitude = 0;
        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            if(current == 'D'){
                if(stack.isEmpty() && altitude != 0){
                    altitude--;
                    continue;
                }
                stack.push(current);
                altitude--;
            }else{
                if(!stack.isEmpty() && stack.peek() == 'D'){
                    stack.pop();
                    if(stack.isEmpty()){
                        result++;
                    }
                }
                altitude++;
            }
        }

        return result;

    }
}
