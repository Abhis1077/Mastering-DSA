class Solution {

    // public int solve(int i, int n, int[] cost, int[] dp){
    //     if(i >=n){
    //         return 0;
    //     }
    //     if(dp[i] != -1){
    //         return dp[i];
    //     }
    //     int one_step = solve(i+1,n,cost,dp);
    //     int two_step = solve(i+2,n,cost,dp);

    //     return dp[i] = cost[i] + Math.min(one_step,two_step);
    // }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = Math.min(cost[0],cost[1]);

        for(int i = 3;i<=n;i++){
            dp[i] = Math.min((dp[i-2]+cost[i-2]),(dp[i-1]+cost[i-1]));
        }
       

        return dp[n];
    }
}