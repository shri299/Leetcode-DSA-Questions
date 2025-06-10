class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
        }
        if(sum%2!=0) return false;
        Boolean[][] dp = new Boolean[nums.length][sum/2 + 1];
        return helper(nums.length-1,sum/2,nums,dp);
    }

    private static boolean helper(int index, int target, int[] arr, Boolean[][] dp){
        if(target==0) return true;
        if (index==0) return arr[index]==target;

        if (dp[index][target]!=null) return dp[index][target];
        boolean notPick = helper(index-1,target,arr,dp);
        boolean pick = false;
        if (arr[index]<target)
            pick = helper(index-1,target-arr[index],arr,dp);

        return dp[index][target] = notPick || pick;
    }

}