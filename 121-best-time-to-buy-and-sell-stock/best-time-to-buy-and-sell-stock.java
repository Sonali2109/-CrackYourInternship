class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];

        for(int i=1;i<prices.length;i++)
        {
            if(buy > prices[i]){
                buy = prices[i];
            }
            else if(maxProfit < prices[i] - buy){
                maxProfit = prices[i] - buy;
            }
        }
        return maxProfit;
    }
}