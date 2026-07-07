class Solution {

    public int solve(int i, int n, int[] cost, int[] dp){
        if(i >=n){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int one_step = solve(i+1,n,cost,dp);
        int two_step = solve(i+2,n,cost,dp);

        return dp[i] = cost[i] + Math.min(one_step,two_step);
    }
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;

        int[] dp = new int[len];
        Arrays.fill(dp,-1);

        return Math.min(solve(0,len,cost, dp),solve(1,len,cost,dp));
    }
}