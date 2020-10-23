package Week7;

public class CountingBits {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        if(num == 0){
            return result;
        }
        result[1] = 1;
        if(num == 1){
            return result;
        }
        result[2] = 1;
        if(num == 2){
            return result;
        }
        int latestPower = 2;
        for(int i = 3; i <= num; i++){
            System.out.println(latestPower);
            double log = Math.log(i) / Math.log(2);
            if(log == (int)log){
                result[i] = 1;
                latestPower = i;
            }else{
                result[i] = 1 + result[i - latestPower];
            }
        }
        return result;
    }
}
