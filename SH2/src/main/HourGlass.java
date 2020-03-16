package main;

public class HourGlass {

    public static void main(String[] args) {
	// write your code here
    }

    static int hourglassSum(int[][] arr) {
        int[][] moves = new int[][]{{0,1}, {0,2}, {2,0}, {2,1}, {2,2}, {1,1}};
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length - 2; i++){
            for(int j = 0; j < arr[0].length - 2; j++){
                int sum = arr[i][j];
                for(int[] move : moves){
                    sum += arr[i + move[0]][j + move[1]];
                }

                if(sum > max){
                    max = sum;
                }
            }
        }

        return max;

    }
}
