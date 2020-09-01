package sample;

public class FirstBadVersion {
    public static void main(String[] args) {

    }

    public static int firstBadVersion(int n) {
        int min = 0, max = n, mid = 0;
        while(min < max){
            mid = min + (max - min) / 2;
            if(isBadVersion(mid)){
                max = mid;
            }else{
                min = mid + 1;
            }
        }

        return min;
    }

    static boolean isBadVersion(int n){
        return true;
    }
}
