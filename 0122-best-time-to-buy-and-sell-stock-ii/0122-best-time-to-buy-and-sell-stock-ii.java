class Solution {
    public int maxProfit(int[] prices) {
        int maxm = 0;
        //int[] dp = new int[prices.length];
        //int minP = prices[0];

        int curr = 0;


        for(int i = 1 ; i <prices.length ; i++){
            // if(prices[i]<minP){
            //     minP = prices[i];
            // }
            // else{
            //     maxm = maxm + prices[i]-minP;
            //     minP = prices[i];
            // }

            //BETTER APPROACH
            // if((prices[i]-prices[i-1]) > 0){
            //     maxm = maxm + (prices[i]-prices[i-1]);
            // }
            if((prices[i] > prices[i-1])){
       
                curr = curr + (prices[i] - prices[i-1]);
            }
            
        }
        return curr;
    }
}