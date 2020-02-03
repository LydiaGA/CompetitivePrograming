package main;

import java.util.HashSet;
import java.util.Set;

public class BitwiseORs {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> previous = new HashSet<>();
        Set<Integer> current = new HashSet<>();

        for(int i = 0; i < A.length; i++){
            current.add(A[i]);
            result.add(A[i]);
            for(int item : previous){
                int itemResult = item | A[i];
                current.add(itemResult);
                result.add(itemResult);
            }

            previous = new HashSet<>(current);
            current = new HashSet<>();
        }

        return result.size();
    }
}
