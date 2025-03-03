class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,nums.length-1,dp);
    }

    //Recursion : O(2^n)
    // private int helper(int[] nums,int index){
    //     if(index==0){
    //         return nums[index];
    //     }
    //     if(index<0){
    //         return 0;
    //     }

    //     int pick = nums[index] + helper(nums,index-2);
    //     int notPick = helper(nums,index-1);

    //     return Math.max(pick,notPick);
    // }


    private int helper(int[] nums,int index, int[] dp){
        if(index==0){
            return nums[index];
        }
        if(index<0){
            return 0;
        }
        int pick = 0;
        if(index-2>0 && dp[index-2]!=-1){
            pick = nums[index] + dp[index-2];
        }else{
            pick = nums[index] + helper(nums,index-2,dp);
        }

        int notPick = 0;
        if(dp[index-1]!=-1){
            notPick = dp[index-1];
        }else{
            notPick = helper(nums,index-1,dp);
        }

        return dp[index] = Math.max(pick,notPick);
    }
}