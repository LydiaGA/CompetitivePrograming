package sample;

import java.util.ArrayList;
import java.util.Stack;

public class MinStack {

    ArrayList<Integer> list;
    Stack<Integer> minStack = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        if(minStack.isEmpty()){
            minStack.push(x);
        }else if(x <= minStack.peek()){
           minStack.push(x);
        }
        list.add(x);
    }

    public void pop() {
        if(list.get(list.size() - 1).equals(minStack.peek())){
            minStack.pop();
        }
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(0);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        //System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
