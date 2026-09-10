class Solution {
    public int maxProfit(int[] prices) {
        int maxm = 0;
        int minP = prices[0];

        for(int i = 0 ; i <prices.length ; i++){
            if(prices[i]<minP){
                minP = prices[i];
            }
            else{
                maxm = maxm + prices[i]-minP;
                minP = prices[i];
            }
        }
        return maxm;
    }
}