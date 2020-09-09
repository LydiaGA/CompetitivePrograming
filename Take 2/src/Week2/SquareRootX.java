package Week2;

public class SquareRootX {
    public int mySqrt(int x) {
        int min = 0, max = x, mid;
        while(min < max){
            mid = min + (max - min) / 2;
            long temp = (long) mid * (long) mid;
            long next = (long) (mid + 1) * (long) (mid + 1);
            if((temp == x) || (temp < x && next > x)){
                return mid;
            }else if(x < temp){
                max = mid;
            }else{
                min = mid + 1;
            }
        }

        return x;
    }
}
