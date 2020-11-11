package Week4;

import java.util.ArrayList;
import java.util.List;

public class ShortestBridge {
    public int shortestBridge(int[][] A) {
        List<List<int[]>> islands = new ArrayList<>();
        boolean[][] visited = new boolean[A.length][A[0].length];
        int[][] moves = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[i].length; j++){
                if(!visited[i][j] && A[i][j] == 1){
                    List<int[]> island = new ArrayList<>();
                    findIsland(A, new int[]{i, j}, visited, moves, island);
                    islands.add(island);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < islands.get(0).size(); i++){
            for(int j = 0; j < islands.get(1).size(); j++){
                int distance = Math.abs(islands.get(0).get(i)[0] - islands.get(1).get(j)[0]) + Math.abs(islands.get(0).get(i)[1] - islands.get(1).get(j)[1]) - 1;
                if(distance < min){
                    min = distance;
                }
            }
        }

        return min;
    }

    void findIsland(int[][] A, int[] start, boolean[][] visited, int[][] moves, List<int[]> island){
        visited[start[0]][start[1]] = true;
        island.add(start);
        for(int[] move : moves){
            int[] child = new int[]{start[0] + move[0], start[1] + move[1]};
            if(child[0] >= 0 && child[0] < A.length && child[1] >= 0 && child[1] < A[0].length &&
                    !visited[child[0]][child[1]] && A[child[0]][child[1]] == 1){
                findIsland(A, child, visited, moves, island);
            }
        }
    }
}
