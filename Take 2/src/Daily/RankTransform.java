package Daily;

import java.util.*;

public class RankTransform {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int rank = 1;
        int[] result = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }

        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                for(int j = 0; j < map.get(arr[i]).size(); j++){
                    result[map.get(arr[i]).get(j)] = rank;
                }
                rank++;
                map.remove(arr[i]);
            }


        }

        return result;

    }
}
