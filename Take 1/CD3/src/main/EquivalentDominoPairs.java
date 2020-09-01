package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EquivalentDominoPairs {

    public static void main(String[] args) {
	// write your code here
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < dominoes.length; i++){
            String current = Arrays.toString(dominoes[i]);
            String fliped = flip(dominoes[i]);
            if(map.containsKey(current)){
                map.replace(current, map.get(current) + 1);
            }else if(map.containsKey(fliped)) {
                map.replace(fliped, map.get(fliped) + 1);
            }else{
                map.put(Arrays.toString(dominoes[i]), 1);
            }
        }

        System.out.println(map.toString());

        int count = 0;

        for(String key : map.keySet()){
            int n = map.get(key);
            //System.out.println(key[0] + " " + key[1]);
            count += ((n - 1) * n) / 2;
        }

        return count;
    }

    String flip(int[] input){
        return Arrays.toString(new int[]{input[1], input[0]});
    }
}
