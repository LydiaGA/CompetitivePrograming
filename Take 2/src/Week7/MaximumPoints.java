package Week7;

public class MaximumPoints {
    public int maxScore(int[] cardPoints, int k) {
        int total = 0;
        int tempSum = 0;
        int window = 0;
        int remaining = cardPoints.length - k;
        for(int i = 0; i < cardPoints.length; i++){
            total += cardPoints[i];
        }

        int min = total;

        for(int i = 0; i < cardPoints.length; i++){
            if(window < remaining){
                window++;
            }else{
                if(tempSum < min){
                    min = tempSum;
                }
                tempSum -= cardPoints[i - remaining];

            }

            tempSum += cardPoints[i];
        }

        if(tempSum < min){
            min = tempSum;
        }

        return total - min;
    }
}
