package sample;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> reversedStack;

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        reverseStack();
        int result = reversedStack.pop();
        reverseStackBack();

        return result;
    }

    /** Get the front element. */
    public int peek() {
        reverseStack();
        int result = reversedStack.peek();
        reverseStackBack();

        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty();
    }

    private void reverseStack(){
        Stack<Integer> reversed = new Stack<>();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            int pop = stack.pop();
            reversed.push(pop);
        }

        reversedStack = reversed;
    }

    private void reverseStackBack(){
        Stack<Integer> reversed = new Stack<>();
        int size = reversedStack.size();
        for (int i = 0; i < size; i++) {
            int pop = reversedStack.pop();
            reversed.push(pop);
        }

        stack = reversed;
    }
}
