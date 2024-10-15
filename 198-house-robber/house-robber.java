class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);

        return solve(dp,nums,nums.length-1);
    }

    private int solve(int[] dp, int[] nums, int len){
        if(len==0){
            return nums[len];
        }
        if(len<0){
            return 0;
        }
        if(dp[len]!=-1){
            return dp[len];
        }

        int m1 = nums[len] + solve(dp,nums,len-2);
        int m2 = 0 + solve(dp,nums,len-1);

        return dp[len]=Math.max(m1,m2);
    }
}