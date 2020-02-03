package main;

public class MonotonicArray {

    public boolean isMonotonic(int[] A) {
        boolean isIncreasing = false, isDecreasing = false;
        if(A.length == 1){
            return true;
        }
        for(int i = 0; i < A.length - 1; i++){
            if(!isIncreasing && !isDecreasing && A[i] < A[i + 1]){
                isIncreasing = true;
                continue;
            }else if(!isDecreasing && !isIncreasing && A[i] > A[i + 1]){
                isDecreasing = true;
                continue;
            }

            if(isIncreasing && A[i] > A[i + 1]){
                return false;
            }else if(isDecreasing && A[i] < A[i + 1]){
                return false;
            }
        }

        return true;
    }
}
