package main;

import java.util.Arrays;

public class OrderlyQueue {
    public String orderlyQueue(String S, int K) {
        char[] sArr = S.toCharArray();
        String temp, minimumString = S;
        if(K == 1){
            for(int i = 0; i < S.length(); i++){
                temp = S.substring(i, S.length()) + S.substring(0, i);
                if(temp.compareTo(minimumString) < 0){
                    minimumString = temp;
                }
            }
            return minimumString;
        }else{
            Arrays.sort(sArr);
            return new String(sArr);
        }
    }
}
