package main;

public class ClimbStairs {

    public static void main(String[] args) {
	// write your code here
    }

    public int climbStairs(int n) {
        int previous = 1;
        int beforePrevious = 0;
        int current = 0;
        for(int i = 2; i <= n; i++){
            current = previous + beforePrevious;
            beforePrevious = previous;
            previous = current;
        }

        return previous + beforePrevious;
    }
}
