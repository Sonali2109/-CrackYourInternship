class Solution {
    public int maxProfit(int[] prices) {

        int buy = prices[0];
        int profit = 0;

        for(int i = 1;i<prices.length;i++)
        {
            if(prices[i-1]>prices[i])
            {
                profit += prices[i-1] - buy ;
                buy = prices[i];
            }
        }
        
        profit += prices[prices.length-1] - buy;
        
        return profit;   
    }
}