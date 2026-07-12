class Solution {

    // public int countMoney(int i , int[] nums, int[] dp){
        
    //     if(i == 0){
    //         return nums[0];
    //     }
    //     if(i < 0 ){
    //         return 0;
    //     }
    //     if(dp[i] != -1){
    //         return dp[i];
    //     }

        
    //     return dp[i] = Math.max((nums[i] + countMoney(i-2,nums,dp)),countMoney(i-1,nums,dp));
    // }
    // public int rob(int[] nums) {
     
    //     int n = nums.length;

    //     int[] dp = new int[n];
    //     Arrays.fill(dp,-1);

    //     return countMoney(n-1, nums,dp);
    // }


    //Bottom Up
    // public int rob(int[] nums) {
     
    //     int n = nums.length;

    //     int[] dp = new int[n];

    //     dp[0] = nums[0];
    //     dp[1] = Math.max(nums[0],nums[1]);

    //     for(int i = 2 ; i <n ;i++){

    //         dp[i] = Math.max((nums[i]+dp[i-2]), dp[i-1]);
    //     }
    //     return dp[n-1];
    // }

    //Space Optimisation

    public int rob(int[] nums) {
     
        int n = nums.length;

        if(n == 0) return 0;
        if (n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);

        int prev1 = nums[0];
        int prev = Math.max(nums[0],nums[1]);
        int curr = 0;

        for(int i = 2 ; i <n ;i++){

            curr = Math.max((nums[i]+prev1), prev);
            prev1 = prev;
            prev = curr;
        }
        return curr;
    }

}