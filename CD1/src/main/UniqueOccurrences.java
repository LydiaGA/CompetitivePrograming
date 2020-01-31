package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueOccurrences {

    public static void main(String[] args) {
	// write your code here
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurences = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(occurences.containsKey(arr[i])){
                occurences.replace(arr[i], occurences.get(arr[i]) + 1);
            }else{
                occurences.put(arr[i], 1);
            }
        }

        Set<Integer> occurencesSet = new HashSet<>();
        for(int key : occurences.keySet()){
            if(occurencesSet.contains(occurences.get(key))){
                return false;
            }else{
                occurencesSet.add(occurences.get(key));
            }
        }

        return true;
    }
}
