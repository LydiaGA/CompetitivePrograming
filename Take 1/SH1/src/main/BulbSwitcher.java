package main;

import java.util.HashSet;
import java.util.Set;

public class BulbSwitcher {
    public int numTimesAllBlue(int[] light) {
        Set<Integer> on = new HashSet<>();
        int maxOn = 0;
        int lastBlue = 0;
        int moments = 0;
        for(int i = 0; i < light.length; i++){
            on.add(light[i]);
            if(light[i] == lastBlue + 1){
                lastBlue = light[i];
                for(int j = light[i]; j <= maxOn; j++){
                    if(on.contains(j)){
                        lastBlue = j;
                    }else{
                        break;
                    }
                }
            }

            if(light[i] > maxOn){
                maxOn = light[i];
            }

            if(lastBlue == maxOn){
                moments++;
            }

        }

        return moments;
    }
}
