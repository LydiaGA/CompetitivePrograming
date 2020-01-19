package sample;

public class SmallestDivisible {
    public static void main(String[] args) {
        System.out.println(smallestRepunitDivByK(33333));
    }

    public static int smallestRepunitDivByK(int K) {
        int N = 1;
        int result = 1;
        if(K % 2 == 0 || K % 5 == 0){
            return -1;
        }else{
            while(true){
                if(result > K){
                    result = -1;
                    break;
                }
                if(N % K == 0){
                    break;
                }
                N = ((N % K) * 10) + 1;
                result++;
            }
        }

        return result;
    }
}
