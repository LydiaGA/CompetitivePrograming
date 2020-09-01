package sample;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
//        MyQueue myQueue = new MyQueue();
//        myQueue.push(5);
//        myQueue.push(6);
//        myQueue.push(7);
//        int peek = myQueue.peek();
//        System.out.println(myQueue.pop());
//        System.out.println(myQueue.pop());
//        myQueue.push(8);
//        System.out.println(myQueue.pop());
//        System.out.println(myQueue.pop());
//        System.out.println(myQueue.empty());

        MyStack myStack = new MyStack();
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);
        //int top = myStack.top();
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        //System.out.println(myStack.pop());

//        System.out.println(myStack.pop());
//        System.out.println(myStack.top());
//        myStack.push(8);
//        System.out.println(myStack.empty());
//        System.out.println(myStack.pop());
        System.out.println(myStack.empty());






    }
}
