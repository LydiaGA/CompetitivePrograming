package main;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[][] sums = new int[grid.length][grid[0].length];
        int result = getPathSum(grid, new int[]{0, 0}, sums);
        return result;
    }

    int getPathSum(int[][] grid, int[] start, int[][] sums){
        System.out.println(start[0] + " " + start[1]);
        if(sums[start[0]][start[1]] != 0){
            System.out.println("visited");
            System.out.println(sums[start[0]][start[1]]);
            return sums[start[0]][start[1]];
        }

        if(start[0] == grid.length - 1 && start[1] == grid[0].length - 1){
            System.out.println("last " + grid[start[0]][start[1]]);
            return grid[start[0]][start[1]];
        }

        int sum = 0;
        if(start[0] + 1 < grid.length && start[1] + 1 < grid[0].length) {
            int rightSum = getPathSum(grid, new int[]{start[0] + 1, start[1]}, sums);
            int downSum = getPathSum(grid, new int[]{start[0], start[1] + 1}, sums);
            sum = Math.min(rightSum, downSum);
        }else if(start[0] + 1 < grid.length){
            sum = getPathSum(grid, new int[]{start[0] + 1, start[1]}, sums);
        }else if(start[1] + 1 < grid[0].length){
            sum = getPathSum(grid, new int[]{start[0], start[1] + 1}, sums);
        }

        sum += grid[start[0]][start[1]];
        sums[start[0]][start[1]] = sum;
        System.out.println(sums[start[0]][start[1]]);
        return sum;
    }
}
