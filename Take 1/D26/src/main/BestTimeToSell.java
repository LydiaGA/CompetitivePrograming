package main;

public class BestTimeToSell {

    public static void main(String[] args) {
	// write your code here
    }

    public int maxProfit(int[] prices) {
        int buy = 0, sell = 0, profit = 0;
        for(int i = 0; i < prices.length; i++){

            if(i == 0){
                if(prices.length > 1 && prices[i] > prices[i + 1]){
                    continue;
                }else{
                    buy = prices[i];
                    System.out.println(prices[i]);
                }
            }else if(i == prices.length - 1){
                if(prices[i] >= prices[i - 1]){
                    sell = prices[i];
                    System.out.println("sell" + prices[i]);
                    profit += (sell - buy);
                }else{
                    continue;
                }
            }else if(prices[i] <= prices[i + 1] && prices[i] < prices[i - 1]){
                buy = prices[i];
                System.out.println(prices[i]);
            }else if(prices[i] > prices[i + 1] && prices[i] >= prices[i - 1]){
                sell = prices[i];
                System.out.println("sell" + prices[i]);
                profit += (sell - buy);
            }
        }

        return profit;
    }
}
