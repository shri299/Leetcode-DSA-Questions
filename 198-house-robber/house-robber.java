class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);

        //Tabulation

        // dp[0] = nums[0];
        // int take = 0;
        // int notTake = 0;

        // for(int i=1;i<nums.length;i++){
        //     if(i>1){
        //         take = take + dp[i-2];
        //     }
            
        //     take = nums[i];
            
        //     notTake = dp[i-1];

        //     dp[i] = Math.max(take,notTake);
        // }

        return solve(dp,nums,0);
        //return dp[nums.length-1];
    }

    //memoization

    private int solve(int[] dp, int[] nums, int len){
        if(len==nums.length-1){
            return nums[len];
        }
        if(len>nums.length-1){
            return 0;
        }
        if(dp[len]!=-1){
            return dp[len];
        }

        int m1 = nums[len] + solve(dp,nums,len+2);
        int m2 = 0 + solve(dp,nums,len+1);

        return dp[len]=Math.max(m1,m2);
    }
}