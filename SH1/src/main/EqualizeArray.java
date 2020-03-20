package main;

import java.util.HashMap;
import java.util.Map;

public class EqualizeArray {
    static int equalizeArray(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxOccurence = 0;

        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                map.replace(arr[i], map.get(arr[i]) + 1);
            }else{
                map.put(arr[i], 1);
            }
        }

        for(int key : map.keySet()){
            if(map.get(key) > maxOccurence){
                maxOccurence = map.get(key);
            }
        }

        return arr.length - maxOccurence;

    }
}
