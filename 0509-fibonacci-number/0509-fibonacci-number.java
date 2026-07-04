class Solution {
    public int fib(int n) {

//Space optimisation
        if(n<=1){
            return n;
        }
        //int[] dp = new int[n+1];

        int a = 0;
        int b = 1;
        int c= 0;

        for(int i = 2 ; i<=n;i++ ){
            c = a + b;
            a = b;
            b = c;
            
        }

        return c;
    }
}
// class Solution {
//     public int fib(int n) {

// //bottom up approach
//         if(n<=1){
//             return n;
//         }
//         int[] dp = new int[n+1];

//         dp[0] = 0;
//         dp[1] = 1;

//         for(int i = 2 ; i<=n;i++ ){
//             dp[i] = dp[i-1]+dp[i-2];
//         }

//         return dp[n];
//     }
// }


//TOP DOWN APPROACH
// class Solution {

//     public int fibon(int n , int[] dp){
//         if(n <=1){
//             return n;
//         }
//         if(dp[n] != -1){
//             return dp[n];
//         }
//         return dp[n] = fibon(n-1, dp) + fibon(n-2,dp);
//     }
//     public int fib(int n) {

//         int[] dp = new int[n+1];

//         Arrays.fill(dp,-1);
        
//         return fibon(n,dp);
//     }
// }