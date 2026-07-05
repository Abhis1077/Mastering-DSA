class Solution {

     public int countstairs(int i , int n, int[] dp){
        if(i==n){
                return 1;
            }
        if(i>n){
                return 0;
            }
        if(dp[i] != -1){
            return dp[i];
        }

        return dp[i] = countstairs(i+1,n,dp) + countstairs(i+2,n,dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+2];
        Arrays.fill(dp,-1);
        return countstairs(0 ,n,dp);
    }
}