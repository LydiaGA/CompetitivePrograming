package Week6;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Count> queue = new PriorityQueue<>((Count1, Count2) -> Count2.count - Count1.count);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            char current = S.charAt(i);
            if(!map.containsKey(current)){
                map.put(current, 1);
            }else{
                map.replace(current, map.get(current) + 1);
            }
        }

        for(char key : map.keySet()){
            queue.add(new Count(key, map.get(key)));
        }


        boolean result = true;
        while(result && !queue.isEmpty()){
            Count removed;
            Count current = queue.poll();
            if(sb.length() != 0 && current.chr == sb.charAt(sb.length() - 1)){
                removed = current;
                if(queue.isEmpty()){
                    result = false;
                }else{
                    current = queue.poll();
                    sb.append(current.chr);
                    queue.add(removed);
                }
            }else{
                sb.append(current.chr);
            }

            current.count -= 1;
            if(current.count != 0){
                queue.add(current);
            }
        }


        if(result){
            return sb.toString();
        }else{
            return "";
        }


    }

}

class Count{
    public char chr;
    public int count;

    public Count(char chr, int count){
        this.chr = chr;
        this.count = count;
    }
}
