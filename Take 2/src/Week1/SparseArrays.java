package Week1;

import java.util.HashMap;
import java.util.Map;

public class SparseArrays {
    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] result = new int[queries.length];
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < strings.length; i++){
            if(!map.containsKey(strings[i])){
                map.put(strings[i],1);
            }else{
                map.replace(strings[i], map.get(strings[i]) + 1);
            }
        }

        for(int i = 0; i < queries.length; i++){
            if(map.containsKey(queries[i])){
                System.out.println(map.containsKey(queries[i]));
                result[i] = map.get(queries[i]);
            }else{
                result[i] = 0;
            }

        }

        return result;

    }
}
