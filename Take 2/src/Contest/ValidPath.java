package Contest;

import java.util.*;

public class ValidPath {
    public boolean hasValidPath(int[][] grid) {
        Map<Integer, Set<String>> map = new HashMap<>();
        map.put(1, new HashSet<>(Arrays.asList("1l", "1r", "3r", "4l", "5r", "6l")));
        map.put(2, new HashSet<>(Arrays.asList("2t", "2b", "3t", "4t", "5b", "6b")));
        map.put(3, new HashSet<>(Arrays.asList("1l", "2b", "4l", "5b", "6l", "6b")));
        map.put(4, new HashSet<>(Arrays.asList("1r", "2b", "3r", "5b", "5r", "6b")));
        map.put(5, new HashSet<>(Arrays.asList("1l", "2t", "3t", "4t", "4l", "6l")));
        map.put(6, new HashSet<>(Arrays.asList("1r", "2t", "3t", "3r", "4t", "5r")));

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] moves = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        return doDFS(grid, new int[]{0, 0}, moves, map, visited);
    }

    boolean doDFS(int[][] grid, int[] start, int[][] moves, Map<Integer, Set<String>> validMoves, boolean[][] visited){
        visited[start[0]][start[1]] = true;
        if(start[0] == grid.length - 1 && start[1] == grid[0].length - 1){
            return true;
        }

        boolean result = false;
        for(int[] move : moves){
            int[] child = new int[]{start[0] + move[0], start[1] + move[1]};
            if(child[0] >= 0 && child[0] < grid.length && child[1] >= 0 && child[1] < grid[0].length){
                String direction = Integer.toString(grid[child[0]][child[1]]);
                direction += move[0] == 1 ? "b" : move[0] == -1 ? "t" : move[1] == 1 ? "r" : "l";
                if(!visited[child[0]][child[1]] && validMoves.get(grid[start[0]][start[1]]).contains(direction)){
                    result = doDFS(grid, child, moves, validMoves, visited) || result;
                }
            }
        }

        return result;
    }
}
