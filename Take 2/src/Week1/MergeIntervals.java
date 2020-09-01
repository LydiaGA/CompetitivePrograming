package Week1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> tempResult = new ArrayList<>();
        if(intervals.length == 0){
            return new int[][]{};
        }

        int[][] sorted = sort(intervals);
        int start = sorted[0][0];
        int end = sorted[0][1];

        for(int i = 1; i < sorted.length; i++){
            if(sorted[i][0] <= end && sorted[i][1] > end){
                end = sorted[i][1];
            }else if(sorted[i][0] > end){
                tempResult.add(new int[]{start, end});
                start = sorted[i][0];
                end = sorted[i][1];
            }
        }

        tempResult.add(new int[]{start, end});

        int[][] result = new int[tempResult.size()][2];
        for(int i = 0; i < tempResult.size(); i++){
            result[i] = tempResult.get(i);
        }

        return result;
    }

    int[][] sort(int[][] input) {
        int[][] sorted = new int[input.length][2];
        int max = getMax(input);

        Map<Integer, List<int[]>> count = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            if(!count.containsKey(input[i][0])){
                count.put(input[i][0], new ArrayList<>());
            }
            count.get(input[i][0]).add(input[i]);
        }

        int counter = 0;
        for (int i = 0; i < max + 1; i++) {
            if(count.containsKey(i)){
                for (int j = 0; j < count.get(i).size(); j++) {
                    sorted[counter] = count.get(i).get(j);
                    counter++;
                }
            }
        }

        return sorted;

    }

    int getMax(int[][] array){
        int max = array[0][0];
        for (int i = 1; i < array.length; i++) {
            if(array[i][0] > max){
                max = array[i][0];
            }
        }

        return max;
    }
}
