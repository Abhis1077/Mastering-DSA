class Solution {

    //Top down Approach
    //  public int countstairs(int i , int n, int[] dp){
    //     if(i==n){
    //             return 1;
    //         }
    //     if(i>n){
    //             return 0;
    //         }
    //     if(dp[i] != -1){
    //         return dp[i];
    //     }

    //     return dp[i] = countstairs(i+1,n,dp) + countstairs(i+2,n,dp);
    // }
    // public int climbStairs(int n) {
    //     int[] dp = new int[n+2];
    //     Arrays.fill(dp,-1);
    //     return countstairs(0 ,n,dp);
    // }

    //Bottom up approach
    
    // public int climbStairs(int n) {
    //     int[] dp = new int[n+2];
      
    //      dp[n] = 1;
            
     
    //      dp[n+1] = 0;
            
    //     for(int i = n-1 ; i>=0;i--){
    //          dp[i] = dp[i+1] + dp[i+2];
    //     }
    //     return dp[0];
    // }

    //SPace optimisation

    public int climbStairs(int n) {
        int curr = 0;
        int prev = 1;
        int prev1 = 0;
      
            
        for(int i = n-1 ; i>=0;i--){
            curr = prev + prev1;
            prev1 = prev;
            prev = curr;
        }
        return curr;
    }
}