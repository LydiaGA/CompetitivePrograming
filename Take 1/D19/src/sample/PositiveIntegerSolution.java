package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositiveIntegerSolution {

    public static void main(String[] args) {
        System.out.println(findSolution(new CustomFunction(), 5).toString());
    }

    public static List<List<Integer>> findSolution(CustomFunction customFunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        int min, max, mid;
        for (int i = 1; i < 1000; i++) {
            max = 1000;
            min = 1;
            while(min < max){
                mid = min + (max - min) / 2;
                if(z == customFunction.f(i, mid)){
                    result.add(Arrays.asList(i, mid));
                    break;
                }else if(z < customFunction.f(i, mid)){
                    max = mid;
                }else{
                    min = mid + 1;
                }
            }
        }

        return result;
    }
}

class CustomFunction {
    public int f(int x, int y){
        return x + y;
    };
}
