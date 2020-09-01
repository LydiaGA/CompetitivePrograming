package main;

public class CountNegative {

    public static void main(String[] args) {
	// write your code here
    }

    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] < 0){
                    count++;
                }
            }
        }

        return count;
    }
}
