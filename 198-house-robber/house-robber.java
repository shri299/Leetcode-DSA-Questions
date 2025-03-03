class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        
        //Tabulation
        int max = Integer.MIN_VALUE;
        if(nums.length==1) return nums[0];
        for(int i=0;i<nums.length;i++){
            int pick = 0;
            if(i-2<0){
                pick = nums[i];
            }else{
                pick = nums[i] + dp[i-2];
            }

            int notPick = 0;
            if(i-1>=0){
                notPick = dp[i-1];
            }
            max = Math.max(pick,notPick);
            dp[i] = max;
        }

        return max;
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


    //Memoization

    // private int helper(int[] nums,int index, int[] dp){
    //     if(index==0){
    //         return nums[index];
    //     }
    //     if(index<0){
    //         return 0;
    //     }
    //     int pick = 0;
    //     if(index-2>0 && dp[index-2]!=-1){
    //         pick = nums[index] + dp[index-2];
    //     }else{
    //         pick = nums[index] + helper(nums,index-2,dp);
    //     }

    //     int notPick = 0;
    //     if(dp[index-1]!=-1){
    //         notPick = dp[index-1];
    //     }else{
    //         notPick = helper(nums,index-1,dp);
    //     }

    //     return dp[index] = Math.max(pick,notPick);
    // }
}