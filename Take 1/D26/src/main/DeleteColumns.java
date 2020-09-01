package main;

public class DeleteColumns {
    public int minDeletionSize(String[] A) {
        boolean foundDecreasing;
        int count = 0;
        for(int i = 0; i < A[0].length(); i++){
            foundDecreasing = false;
            for(int j = 0; j < A.length - 1; j++){
                if(A[j].charAt(i) > A[j + 1].charAt(i)){
                    System.out.println(A[j].charAt(i) + " " + A[j + 1].charAt(i));
                    foundDecreasing = true;
                    break;
                }
            }

            if(foundDecreasing){
                count++;
            }
        }

        return count;
    }
}
