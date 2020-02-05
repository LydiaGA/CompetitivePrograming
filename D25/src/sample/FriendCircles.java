package sample;

import java.util.HashSet;
import java.util.Set;

public class FriendCircles {
    public int findCircleNum(int[][] M) {
        Set<Integer> visited = new HashSet<>();
        int result = 0;
        for(int i = 0; i < M.length; i++){
            if(!visited.contains(i)){
                dfs(M, i, visited);
                result++;
            }
        }

        return result;
    }

    void dfs(int[][] M, int i, Set<Integer> visited){
        visited.add(i);
        for(int j = 0; j < M[i].length; j++){
            if(!visited.contains(j) && M[i][j] == 1){
                dfs(M, j, visited);
            }
        }
    }
}
