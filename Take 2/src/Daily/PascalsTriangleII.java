package Daily;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> previous = new ArrayList<>(List.of(1));
        if(rowIndex == 0){
            return previous;
        }
        previous.add(1);
        if(rowIndex == 1){
            System.out.println(rowIndex);
            return previous;
        }
        for(int i = 2; i <= rowIndex; i++){
            List<Integer> row = new ArrayList<>(List.of(1));
            for(int j = 0; j < previous.size() - 1; j++){
                row.add(previous.get(j) + previous.get(j + 1));
            }
            row.add(1);
            previous = row;
        }

        return previous;
    }
}
