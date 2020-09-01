package sample;

import java.util.*;

public class MatrixCells {
    public static void main(String[] args) {
        int[][] result = allCellsDistOrder(2, 3, 1, 2);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int[] cell = {i, j};
                int distance = Math.abs(i - r0) + Math.abs(j - c0);

                if (map.containsKey(distance)){
                    map.get(distance).add(cell);
                }else{
                    List<int[]> cells = new ArrayList<>();
                    cells.add(cell);
                    map.put(distance, cells);
                }
            }
        }

        Set<Integer> keys = map.keySet();
        int [][] cells = new int[R * C][2];

        int count = 0;
        for (int key: keys) {
            for (int i = 0; i < map.get(key).size(); i++) {
                cells[count] = map.get(key).get(i);
                count++;
            }

        }

        return cells;
    }
}
