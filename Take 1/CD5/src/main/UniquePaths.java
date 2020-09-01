package main;

import java.util.Arrays;

public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }

    public int uniquePaths(int m, int n) {
        int[] start = new int[]{0, 0};
        boolean[][] visited = new boolean[n][m];
        return countPaths(new int[]{0, 0}, m, n, visited);
    }

    int countPaths(int[] start, int m, int n, boolean[][] visited){
        int[][] moves = new int[][]{{start[0] + 1, start[1]}, {start[0], start[1] + 1}};
        System.out.println(Arrays.toString(moves[0]) + " " + Arrays.toString(moves[1]));
        int paths = 0;

        if(start[0] == n - 1 && start[1] == m - 1){
            System.out.println(start[0] + " " + start[1]);
            paths = 1;
        }

        if(moves[0][0] >= 0 && moves[0][0] < n - 1 && !visited[moves[0][0]][moves[0][1]]){
            paths += countPaths(moves[0], m, n, visited);
        }

        if(moves[1][1] >= 0 && moves[1][1] < m - 1 && !visited[moves[1][0]][moves[1][1]]){
            paths += countPaths(moves[1], m, n, visited);
        }

        return paths;
    }
}
