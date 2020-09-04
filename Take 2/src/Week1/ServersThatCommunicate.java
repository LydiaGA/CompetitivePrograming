package Week1;

public class ServersThatCommunicate {
    public int countServers(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] != 0){
                    int tempResult = dfs(grid, visited, new int[]{i,j});
                    if(tempResult > 1){
                        result += tempResult;
                    }
                }
            }
        }
        return result;
    }

    int dfs(int[][] grid, boolean[][] visited, int[] start){
        int temp = 1;
        visited[start[0]][start[1]] = true;
        for(int i = 0; i < grid[0].length; i++){
            if(!visited[start[0]][i] && grid[start[0]][i] == 1){
                temp += dfs(grid, visited, new int[]{start[0], i});
            }
        }
        for(int i = 0; i < grid.length; i++){
            if(!visited[i][start[1]] && grid[i][start[1]] == 1){
                temp += dfs(grid, visited, new int[]{i, start[1]});
            }
        }

        return temp;
    }
}
