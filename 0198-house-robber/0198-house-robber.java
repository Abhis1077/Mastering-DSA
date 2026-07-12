class Solution {

    public int countMoney(int i , int[] nums, int[] dp){
        
        if(i == 0){
            return nums[0];
        }
        if(i < 0 ){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        
        return dp[i] = Math.max((nums[i] + countMoney(i-2,nums,dp)),countMoney(i-1,nums,dp));
    }
    public int rob(int[] nums) {
     
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        return countMoney(n-1, nums,dp);
    }
}