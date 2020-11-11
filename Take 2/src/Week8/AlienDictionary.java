package Week8;

import java.util.HashMap;
import java.util.Map;

public class AlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++){
            map.put(order.charAt(i), i);
        }

        boolean result = true;
        for(int i = 1; i < words.length; i++){
            String shorter = words[i];
            if(words[i - 1].length() < words[i].length()){
                shorter = words[i - 1];
            }
            boolean areEqual = true;
            for(int j = 0; j < shorter.length(); j++){
                if(map.get(words[i - 1].charAt(j)) > map.get(words[i].charAt(j))){
                    return false;
                }else if(map.get(words[i - 1].charAt(j)) < map.get(words[i].charAt(j))){
                    areEqual = false;
                    break;
                }
            }

            if(areEqual){
                if(!shorter.equals(words[i - 1])){
                    return false;
                }
            }
        }

        return result;
    }
}
