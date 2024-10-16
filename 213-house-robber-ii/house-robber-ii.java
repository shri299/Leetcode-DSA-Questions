class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp,-1);
        Arrays.fill(dp2,-1);

        return Math.max(solve(nums,dp,0,nums.length-2),solve(nums,dp2,1,nums.length-1));
    }

    private int solve(int[] nums, int[] dp, int start, int end){
        if(start==end){
            return nums[start];
        }
        if(start>end){
            return 0;
        }
        if(dp[start]!=-1){
            return dp[start];
        }

        int m1 = nums[start] + solve(nums,dp,start+2,end);
        int m2 = solve(nums,dp,start+1,end);

        return dp[start]=Math.max(m1,m2);
    }
}