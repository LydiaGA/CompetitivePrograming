package sample;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyStack {

    Queue<Integer> queue = new LinkedList<>();
    Queue<Integer> reversedQueue;
    boolean isEmpty = true;

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        queue.add(x);
        isEmpty = false;

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Queue<Integer> temp = new LinkedList<>();
        int pop = 0;
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            pop = queue.remove();
            if(i != size - 1){
                temp.add(pop);
            }
        }

//        if(temp.size() == 0){
//            isEmpty = true;
//        }
        queue = temp;

        return pop;
    }

    /** Get the front element. */
    public int top() {
        Queue<Integer> temp = new LinkedList<>();
        int pop = 0;
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            pop = queue.remove();
            temp.add(pop);
        }

        queue = temp;

        return pop;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

}
