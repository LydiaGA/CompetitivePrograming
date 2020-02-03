package main;

import java.util.Stack;

public class MakeParanthesesValid {
    public int minAddToMakeValid(String S) {
        char[] sArr = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < sArr.length; i++){
            if(stack.isEmpty()){
                stack.push(sArr[i]);
                continue;
            }
            char top = stack.peek();
            if(isClosing(top, sArr[i])){
                stack.pop();
            }else{
                stack.push(sArr[i]);
            }
            System.out.println(stack.toString());
        }
        return stack.size();
    }

    boolean isClosing(char a, char b){
        if('(' == a && ')' == b){
            return true;
        }

        return false;
    }
}
