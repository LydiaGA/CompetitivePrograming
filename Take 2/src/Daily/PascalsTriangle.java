package Daily;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows > 0){
            result.add(new ArrayList<>(List.of(1)));
        }

        if(numRows > 1){
            result.add(new ArrayList<>(List.of(1,1)));
        }

        for(int i = 2; i < numRows; i++){
            List<Integer> row = new ArrayList<>(List.of(1));
            List<Integer> previous = result.get(i - 1);
            for(int j = 0; j < previous.size() - 1; j++){
                row.add(previous.get(j) + previous.get(j + 1));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }
}
