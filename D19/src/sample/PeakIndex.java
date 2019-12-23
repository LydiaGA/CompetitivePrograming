package sample;

public class PeakIndex {
    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
    }

    public static int peakIndexInMountainArray(int[] A) {
        int min = 0, max = A.length - 1, mid;
        int result = -1;
        while(min < max){
            mid = min + (max - min) / 2;
            if(A[mid] > A[mid -1] && A[mid] > A[mid + 1]){
                result = mid;
                break;
            }else if(A[mid - 1] < A[mid] && A[mid] < A[mid + 1]){
                min = mid + 1;
            }else{
                max = mid;
            }
        }

        return result;
    }
}
