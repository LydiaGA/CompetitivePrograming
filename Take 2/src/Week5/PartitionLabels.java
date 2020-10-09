package Week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> partitions = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < S.length(); i++){
            char current = S.charAt(i);
            if(map.containsKey(current)){
                for(int j = 0; j < partitions.size(); j++){
                    if(partitions.get(j) < i && partitions.get(j) >= map.get(current)){
                        partitions.remove(j);
                        j--;
                    }
                }
                partitions.add(i);
            }else{
                partitions.add(i);
            }
            map.put(current, i);
        }

        int end = -1;
        for(int i : partitions){
            result.add(i - end);
            end = i;
        }


        return result;
    }
}
