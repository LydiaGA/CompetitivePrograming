package Week2;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int min = 0, max = matrix.length, mid;
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        while(min < max){
            mid = min + (max - min) / 2;
            if(target == matrix[mid][0]){
                return true;
            }else if(mid != 0 && target > matrix[mid - 1][0] && target < matrix[mid][0]){
                return rowSearch(matrix[mid - 1], target);
            }else if(mid == matrix.length - 1 && target > matrix[mid][0]){
                return rowSearch(matrix[mid], target);
            }else if(target < matrix[mid][0]){
                max = mid;
            }else{
                min = mid + 1;
            }
        }

        return false;
    }

    boolean rowSearch(int[] row, int target){
        int min = 0, max = row.length, mid;
        while(min < max){
            mid = min + (max - min) / 2;
            if(target == row[mid]){
                return true;
            }else if(target < row[mid]){
                max = mid;
            }else{
                min = mid + 1;
            }
        }

        return false;
    }
}
