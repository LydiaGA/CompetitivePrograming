package main;

import java.util.PriorityQueue;

public class Squares {

    public static void main(String[] args) {
	// write your code here
    }

    public int[] sortedSquares(int[] A) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0; i < A.length; i++){
            queue.add(A[i] * A[i]);
        }

        int[] result = new int[A.length];

        int size = queue.size();

        for(int i = 0; i < size; i++){
            result[i] = queue.poll();
        }

        return result;
    }
}
