package algorithms.arrays;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = new int []{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int minimumPrice;
        if (prices == null || prices.length < 2) return 0;
        minimumPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++){
            int currentPrice = prices[i];
            int potentialProfit = currentPrice-minimumPrice;
            if(maxProfit < potentialProfit){
                maxProfit = potentialProfit;
            }
            if(prices[i] < minimumPrice){
                minimumPrice = currentPrice;
            }
        }
        return maxProfit;

    }
}
