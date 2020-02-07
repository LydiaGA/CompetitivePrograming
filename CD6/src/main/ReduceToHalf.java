package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReduceToHalf {
    public int minSetSize(int[] arr) {
        List<int[]> countList = sortMap(generateCountMap(arr));
        int length = arr.length;
        int i = countList.size() - 1;
        int counter = 0;
        while(length > arr.length / 2){
            length -= countList.get(i)[0];
            i--;
            counter++;
        }
        return counter;
    }

    Map<Integer, Integer> generateCountMap(int[] arr){
        Map<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(count.containsKey(arr[i])){
                count.replace(arr[i], count.get(arr[i]) + 1);
            }else{
                count.put(arr[i], 1);
            }
        }

        return count;
    }

    List<int[]> sortMap(Map<Integer, Integer> input){
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> countMap = new HashMap<>();
        int[] count = new int[getMax(input) + 1];


        for(int key : input.keySet()){
            if(countMap.containsKey(input.get(key))){
                countMap.get(input.get(key)).add(key);
            }else{
                countMap.put(input.get(key), new ArrayList<>());
                countMap.get(input.get(key)).add(key);
            }

            count[input.get(key)]++;
        }



        for(int i = 0; i < count.length; i++){
            for(int j = 0; j < count[i]; j++){
                result.add(new int[]{i, countMap.get(i).get(j)});

            }
        }

        return result;

    }

    int getMax(Map<Integer, Integer> input){
        int max = 0;
        for(int key : input.keySet()){
            if(input.get(key) > max){
                max = input.get(key);
            }
        }

        return max;
    }
}
