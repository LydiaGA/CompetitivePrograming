package Daily;

public class FourDivisors {

    public int sumFourDivisors(int[] nums) {
        int result = 0;
        for (int num : nums) {
            int tempSum = 0;
            int count = 0;
            if (num > 5) {
                for (int j = 2; j <= Math.sqrt(num); j++) {
                    if (num % j == 0) {
                        tempSum += j;
                        count += 1;
                        if (j != num / j) {
                            count += 1;
                            tempSum += num / j;
                        }
                    }
                }
                if (count == 2) {
                    result += tempSum + 1 + num;
                }
            }
        }

        return result;
    }
}
