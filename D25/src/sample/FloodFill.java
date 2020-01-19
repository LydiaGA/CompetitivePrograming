package sample;

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)));
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] children = new int[][]{{sr - 1, sc}, {sr + 1, sc}, {sr, sc - 1}, {sr, sc + 1}};
        for (int[] child : children) {
            if(child[0] < 0 || child[0] >= image.length || child[1] < 0 || child[1] >= image[0].length){
                continue;
            }

            if(image[child[0]][child[1]] == image[sr][sc]){
                image[child[0]][child[1]] = newColor;
            }
            System.out.println(child[0] + " "+ child[1]);
            return floodFill(image, child[0], child[1], newColor);
        }

        System.out.println("---------------------------");

        return image;
    }
}
