package main;

import java.util.List;

public class Triangle {
    public int uniquePaths(int m, int n) {
        int[] start = new int[]{0, 0};
        int[][] visited = new int[m][n];
        return countPaths(new int[]{0, 0}, m, n, visited);
    }

    int countPaths(int[] start, int m, int n, int[][] visited){
        int[][] moves = new int[][]{{start[0] + 1, start[1]}, {start[0], start[1] + 1}};
        int paths = 0;

        if(visited[start[0]][start[1]] != 0){
            return visited[start[0]][start[1]];
        }

        if(start[0] + 1 == m && start[1] + 1 == n){
            paths = 1;
        }

        if(start[0] + 1 < m && start[1] + 1 < n) {
            paths += countPaths(moves[0], m, n, visited);
            paths += countPaths(moves[1], m, n, visited);
        }else if(start[0] + 1 < m){
            paths += countPaths(moves[0], m, n, visited);
        }else if(start[1] + 1 < n){
            paths += countPaths(moves[1], m, n, visited);
        }


        visited[start[0]][start[1]] = paths;
        return paths;
    }
}
