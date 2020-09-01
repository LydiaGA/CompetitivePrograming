package sample;

import java.util.ArrayList;
import java.util.List;

public class MyCircularDeque {

    List<Integer> deque;
    int k;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        deque = new ArrayList<>();
        this.k = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(deque.size() == k - 1){
            return false;
        }else{
            deque.add(0, value);
            return true;
        }
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(deque.size() == k - 1){
            return false;
        }else{
            deque.add(deque.size() - 1, value);
            return true;
        }
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(deque.size() == 0){
            return false;
        }else{
            deque.remove(0);
            return true;
        }
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(deque.size() == 0){
            return false;
        }else{
            deque.remove(deque.size() - 1);
            return true;
        }
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return  deque.get(0);
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return deque.get(deque.size() - 1);
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return deque.size() == k;
    }
}
