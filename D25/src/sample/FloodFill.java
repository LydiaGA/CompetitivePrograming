package sample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FloodFill {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)));
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initialColor = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        image[sr][sc] = newColor;
        return doFloodFill(image, sr, sc, newColor, visited, initialColor);
    }

    static int[][] doFloodFill(int[][] image, int sr, int sc, int newColor, boolean[][] visited, int initialColor){

        visited[sr][sc] = true;
        int[][] children = new int[][]{{sr - 1, sc}, {sr + 1, sc}, {sr, sc - 1}, {sr, sc + 1}};

        for (int[] child : children) {
            if(child[0] < 0 || child[0] >= image.length || child[1] < 0 || child[1] >= image[0].length){
                continue;
            }else if(visited[child[0]][child[1]]){
                continue;
            }

            if(image[child[0]][child[1]] == initialColor){
                image[child[0]][child[1]] = newColor;
                doFloodFill(image, child[0], child[1], newColor, visited, initialColor);
            }

        }

        return image;
    }
}
