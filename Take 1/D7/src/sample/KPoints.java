package sample;

import com.sun.source.tree.UsesTree;

import java.util.*;

public class KPoints {

    public static void main(String[] args) {
        int[][] result = kClosest(new int[][]{{-5, 4},{-6, -5}, {4, 6}}, 2);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] kClosest(int[][] points, int K) {
        if(K == 0){
            return new int[][]{};
        }
        Map<Double, List<int[]>> map = new HashMap<>();
        double[] distances = new double[points.length];

        for (int i = 0; i < points.length; i++) {
                int[] cell = points[i];
                double distance = Math.sqrt((cell[0] * cell[0])  + (cell[1] * cell[1]));
                distances[i] = distance;
                System.out.println(cell[0] + " " + cell[1] + " : "  + distance);

                if (map.containsKey(distance)){
                    map.get(distance).add(cell);
                }else {
                    List<int[]> cells = new ArrayList<>();
                    cells.add(cell);
                    map.put(distance, cells);
                }
        }

        Set<Double> keys = map.keySet();
        int [][] cells = new int[K][2];
        double[] sorted = sort(distances);

        int count = 0;
        for (double key: sorted) {
            for (int i = 0; i < map.get(key).size(); i++) {
                cells[count] = map.get(key).get(i);
                count++;
                if(count >= K){
                    break;
                }
            }

            if(count >= K){
                break;
            }

        }

        return cells;
    }

    public static double[] sort(double[] input){
        for (int i = 0; i < input.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < input.length; j++) {
                if(input[minIndex] > input[j]){
                    minIndex = j;
                }
            }

            double temp = input[i];
            input[i] = input[minIndex];
            input[minIndex] = temp;

        }

        return input;
    }
}
