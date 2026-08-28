class Solution {

    // public int countMoney(int i , int[] nums, int[] dp){
    //     if(i>=nums.length){
    //         return 0;
    //     }

    //     if(dp[i]!= -1){
    //         return dp[i];
    //     }

    //     return dp[i] = Math.max((nums[i]+ countMoney(i+2,nums,dp)),countMoney(i+1,nums,dp));
    // }

    // public int rob(int[] nums) {
    //     int n = nums.length;

    //     int[] dp1 = new int[n-1];
    //     int[] dp2 = new int[n-1];

    //     Arrays.fill(dp1,-1);
    //     Arrays.fill(dp2,-1);

    //     if(n == 1){
    //         return nums[0];
    //     }

    //     int[] arr1 = new int[n-1];
    //     int[] arr2 = new int[n-1];

    //     for( int i = 0 ; i < n-1 ; i++)
    //     {
    //         arr1[i] = nums[i];
    //     }
    //     for( int i = 1 ; i < n ; i++)
    //     {
    //         arr2[i-1] = nums[i];
    //     }

    //     return Math.max(countMoney(0,arr1,dp1),countMoney(0,arr2,dp2));
    // }
    public int countMoney(int i , int end, int[] nums, int[] dp){
        if(i>end){
            return 0;
        }

        if(dp[i]!= -1){
            return dp[i];
        }

        return dp[i] = Math.max((nums[i]+ countMoney(i+2,end,nums,dp)),countMoney(i+1,end,nums,dp));
    }

    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);

        if(n == 1){
            return nums[0];
        }

        return Math.max(countMoney(0,n-2,nums,dp1),countMoney(1,n-1,nums,dp2));
    }
}