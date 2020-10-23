package Week6;

import java.util.*;

public class QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][2];
        if(people.length == 0){
            return result;
        }
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int min = people[0][0];
        int max = people[0][0];
        List<Integer> positions = new ArrayList();
        for(int i = 0; i < people.length; i++){
            positions.add(i);
            if(people[i][0] > max){
                max = people[i][0];
            }
            if(people[i][0] < min){
                min = people[i][0];
            }

            if(!map.containsKey(people[i][0])){
                map.put(people[i][0], new PriorityQueue<>());
            }

            map.get(people[i][0]).add(people[i][1]);
        }
        for(int i = min; i <= max; i++){

            if(map.containsKey(i)){
                PriorityQueue<Integer> currentList = map.get(i);
                int size = currentList.size();
                for(int j = 0; j < size; j++){
                    int currentItem = currentList.poll();
                    if(j == 0){
                        result[positions.get(currentItem)] = new int[]{i, currentItem};
                        positions.remove((int)currentItem);
                    }else{
                        int index = currentItem - j;
                        result[positions.get(index)] = new int[]{i, currentItem};
                        positions.remove((int)index);
                    }
                }
            }
        }
        return result;
    }
}
