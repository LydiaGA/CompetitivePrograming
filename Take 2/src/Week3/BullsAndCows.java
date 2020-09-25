package Week3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        Map<Character, Set<Integer>> map = new HashMap<>();
        int bulls = 0, cows = 0;
        for(int i = 0; i < secret.length(); i++){
            char current = secret.charAt(i);
            if(!map.containsKey(current)){
                map.put(current, new HashSet<Integer>());
            }
            map.get(current).add(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < guess.length(); i++){
            char current = guess.charAt(i);
            if(map.containsKey(current) && map.get(current).contains(i)){
                bulls += 1;
                map.get(current).remove(i);
            }else{
                sb.append(current);
            }
        }

        for(int i = 0; i < sb.length(); i++){
            char current = sb.charAt(i);
            if(map.containsKey(current) && !map.get(current).isEmpty()){
                cows += 1;
                map.get(current).remove(map.get(current).iterator().next());
            }
        }

        return bulls + "A" + cows + "B";
    }
}
