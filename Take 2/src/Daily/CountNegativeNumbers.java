package Daily;

public class CountNegativeNumbers {
    public int countNegatives(int[][] grid) {
        int prevEnd = grid.length;
        int end = grid.length;
        int count = 0;

        for(int i = 0; i < grid[0].length; i++){
            int min = 0, max = end - 1, mid = 0;
            boolean found = false;
            while(min <= max){
                mid = min + (max - min) / 2;
                if(grid[mid][i] < 0 && (mid == 0 || grid[mid - 1][i] >= 0)){
                    prevEnd = end;
                    end = mid;
                    found = true;
                    break;
                }else if (grid[mid][i] >= 0){
                    min = mid + 1;
                }else{
                    max = mid;
                }
            }

            if(found){
                count += (prevEnd - end) * (grid[0].length - i);
            }

        }
        return count;
    }
}
