class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
        }
        if(sum%2!=0) return false;
        
        
        boolean[][] dp = new boolean[nums.length][sum/2 + 1];

        for(int i=0;i<nums.length;i++){
            dp[i][0]=true;
        }
        if (nums[0] <= sum/2)
            dp[0][nums[0]] = true;

        for (int i=1;i<nums.length;i++){
            for (int target = 1; target <= sum/2; target++){
                boolean notPick = dp[i-1][target];
                boolean pick = false;
                if (nums[i] <= target)
                    pick = dp[i-1][target-nums[i]];
                dp[i][target]=pick||notPick;
            }
        }
        return  dp[nums.length-1][sum/2];
    }

    // private static boolean helper(int index, int target, int[] arr, Boolean[][] dp){
    //     if(target==0) return true;
    //     if (index==0) return arr[index]==target;

    //     if (dp[index][target]!=null) return dp[index][target];
    //     boolean notPick = helper(index-1,target,arr,dp);
    //     boolean pick = false;
    //     if (arr[index]<target)
    //         pick = helper(index-1,target-arr[index],arr,dp);

    //     return dp[index][target] = notPick || pick;
    // }

}