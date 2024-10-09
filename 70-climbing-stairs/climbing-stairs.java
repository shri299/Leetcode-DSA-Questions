class Solution {
    public int climbStairs(int n) {
        //Tabulation with O(1) SC

        int prev1 = 1;
        int prev2 = 1;

        for (int i = 2; i <= n; ++i)
        {
            int curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }

        return prev2;

    }

    //recursion with exponetial TC

    // private int solve(int n){
    //     if(n<=1){
    //         return 1;
    //     }

    //     return solve(n-1) + solve(n-2);
    // }


    //memoization with non-exponential TC

    // private int solve(int n,int[] dp){
    //     if(n<=1){
    //         return 1;
    //     }

    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }

    //     return dp[n] = solve(n-1,dp) + solve(n-2,dp);
    // }


    //tabulation with O(n) SC

    // private void solve(int n){
    //     int[] dp = new int[n + 1];
    //     dp[0] = 1;
    //     dp[1] = 1;

    //     for (int i = 2; i <= n; ++i)
    //     dp[i] = dp[i - 1] + dp[i - 2];

    //     return dp[n];
    // }
}