package Week5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharacters {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            if(!map.containsKey(current)){
                map.put(current, 0);
            }

            map.replace(current, map.get(current) + 1);
        }

        PriorityQueue<Count> queue = new PriorityQueue<>(new CountComparator());
        for(char chr : map.keySet()){
            queue.add(new Count(chr, map.get(chr)));
        }

        // System.out.println(map);

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            Count current = queue.poll();
            for(int i = 0; i < current.count; i++){
                sb.append(current.chr);
            }
        }

        return sb.toString();
    }
}

class CountComparator implements Comparator<Count> {
    public int compare(Count c1, Count c2) {
        if (c1.count < c2.count){
            return 1;
        }else if (c1.count > c2.count) {
            return -1;
        }
        return 0;
    }
}

class Count {
    public char chr;
    public int count;

    public Count(char chr, int count) {
        this.chr = chr;
        this.count = count;
    }

}
