package sample;

public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        boolean valid = false;
        for(int i = 1; i < grid.length - 1; i++){
            for(int j = 1; j < grid[0].length - 1; j++){
                if(grid[i][j] == 0 && !visited[i][j]){
                    valid = dfs(grid, new int[]{i, j}, visited, moves);
                    if(valid){
                        count ++;
                    }

                }
            }
        }

        return count;
    }

    boolean dfs(int[][] grid, int[] start, boolean[][] visited, int[][] moves){
        boolean valid = true;
        visited[start[0]][start[1]] = true;
        if(start[0] == 0 || start[1] == 0 || start[0] == grid.length - 1 || start[1] == grid[0].length - 1){
            valid = false;
        }
        for(int[] move : moves){
            int[] child = {start[0] + move[0], start[1] + move[1]};
            if(child[0] >= 0 && child[0] < grid.length && child[1] >= 0 && child[1] < grid[0].length){
                if(!visited[child[0]][child[1]] && grid[child[0]][child[1]] == 0){
                    valid = dfs(grid, child, visited, moves) && valid;
                }
            }

        }

        return valid;
    }
}
