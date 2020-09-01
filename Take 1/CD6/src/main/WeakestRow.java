package main;

import java.util.*;

public class WeakestRow {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Map<Integer, List<Integer>> countMap = new HashMap<>();
        for(int i = 0; i < mat.length; i++){
            int count = 0;
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 0){
                    break;
                }
                count++;
            }

            if(!countMap.containsKey(count)){
                countMap.put(count, new ArrayList<>());
                queue.add(count);
            }
            countMap.get(count).add(i);
        }

        int counter = 0;
        int size = queue.size();
        for(int i = 0; i < size; i++) {
            int currentCount = queue.poll();
            for(int l : countMap.get(currentCount)){
                if(counter == k){
                    return result;
                }
                result[counter] = l;
                counter++;
            }
        }

        return result;
    }
}
