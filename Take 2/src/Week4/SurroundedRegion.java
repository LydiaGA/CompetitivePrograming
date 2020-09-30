package Week4;

import java.util.ArrayList;
import java.util.List;

public class SurroundedRegion {
    public void solve(char[][] board) {
        if(board.length == 0){
            return;
        }
        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(!visited[i][j] && board[i][j] == 'O'){
                    if(i != board.length - 1 && i != 0 && j != board[0].length - 1 && j != 0){
                        List<int[]> os = new ArrayList<>();
                        boolean surrounded = doDFS(new int[]{i, j}, board, visited, moves, os);
                        if(surrounded){
                            for(int[] o : os){
                                board[o[0]][o[1]] = 'X';
                            }
                        }


                    }
                }
            }
        }
    }

    boolean doDFS(int[] start, char[][] board, boolean[][] visited, int[][] moves, List<int[]> os){
        visited[start[0]][start[1]] = true;
        boolean surrounded = true;
        os.add(start);
        for(int[] move : moves){
            int[] child = {start[0] + move[0], start[1] + move[1]};
            if(!visited[child[0]][child[1]]){
                if(board[child[0]][child[1]] == 'O'){
                    if(child[0] == board.length - 1 || child[0] == 0 || child[1] == board[0].length - 1 || child[1] == 0){
                        surrounded = false;
                    }else{
                        boolean childResult = doDFS(child, board, visited, moves, os);
                        surrounded = surrounded && childResult;
                    }
                }
            }
        }
        return surrounded;
    }
}
