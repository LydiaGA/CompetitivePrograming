package sample;

public class PerfectNumber {

    public static void main(String[] args) {

    }

    public boolean checkPerfectNumber(int num) {
        int sum = 1;
        if(num == 1){
            return false;
        }
        for (int i = 2; i < Math.sqrt(num); i++) {
            if(num % i == 0){
                sum += i;
                sum += num / i;
            }

            if(sum > num){
                break;
            }
        }

        return sum == num;
    }
}
