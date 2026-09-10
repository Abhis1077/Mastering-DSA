class Solution {
    public int maxProfit(int[] prices) {
        int maxm = 0;
        //int minP = prices[0];

        for(int i = 1 ; i <prices.length ; i++){
            // if(prices[i]<minP){
            //     minP = prices[i];
            // }
            // else{
            //     maxm = maxm + prices[i]-minP;
            //     minP = prices[i];
            // }
            if((prices[i]-prices[i-1]) > 0){
                maxm = maxm + (prices[i]-prices[i-1]);
            }
        }
        return maxm;
    }
}