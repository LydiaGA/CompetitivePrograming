package sample;

import java.util.*;

public class KFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, ArrayList<Integer>> map2 = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        Set<Integer> duplicates = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(map1.containsKey(nums[i])){
                map1.put(nums[i], map1.get(nums[i]) + 1);
            }else{
                map1.put(nums[i], 1);
            }
        }

        for(int key : map1.keySet()){
            int val = map1.get(key);

            if(heap.size() == k){
                if(heap.peek() < val){
                    heap.poll();
                    heap.add(val);
                }
            }else{
                heap.add(val);
            }

            if(!map2.containsKey(val)){
                map2.put(val, new ArrayList<>());
            }

            map2.get(val).add(key);
        }

        System.out.println(map2.toString());
        System.out.println(heap.toString());

        int size = heap.size();

        for(int i = 0; i < size; i++){
            int currentVal = heap.poll();
            if(!duplicates.contains(currentVal)){
                List<Integer> current = map2.get(currentVal);
                for(int j = 0; j < current.size(); j++){
                    result.add(0, current.get(j));
                }
                duplicates.add(currentVal);
            }


        }

        return result;
    }
}
