package main;

public class LongestTurbulent {
    public int maxTurbulenceSize(int[] A) {
        boolean isTurbulent = true;
        int status = -1;
        int length = 0, maxLength = 0;

        if(A.length == 1){
            return 1;
        }

        for(int i = 1; i < A.length; i++){
            if(status != 0 && A[i] < A[i - 1]){
                length++;
                status = 0;
                isTurbulent = true;
            }else if(status != 1 && A[i] > A[i - 1]){
                length++;
                status = 1;
                isTurbulent = true;
            }else if(status == 0 && A[i] <= A[i - 1]){
                length++;
                isTurbulent = false;
            }else if(status == 1 && A[i] >= A[i - 1]){
                length++;
                isTurbulent = false;
            }


            if(!isTurbulent){
                if(length > maxLength){
                    maxLength = length;
                }

                if(A[i] == A[i - 1]){
                    length = 0;
                }else{
                    length = 1;
                }

            }
        }

        if(length > maxLength){
            return ++length;
        }

        if(maxLength == 0){
            return 1;
        }

        return maxLength;

    }
}
