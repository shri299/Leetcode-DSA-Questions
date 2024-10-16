class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);


        //tabulation with exptra space complexity

        // dp[nums.length-1] = nums[nums.length-1];//dp[4]=1
        // int take = 0;
        // int notTake = 0;

        // for(int i=nums.length-2;i>=0;i--){
        //     take = nums[i];
        //     if(i<nums.length-2){
        //         take = take + dp[i+2];
        //     }
            
        //     notTake = dp[i+1];

        //     dp[i] = Math.max(take,notTake);//dp[3]=3//dp[2]=10//dp[1]=10//dp[0]=12
        // }

        
        // return dp[0];


        //tabulation with no extra space complexity
        int var1 = nums[nums.length-1];//dp[4]=1
        int take = 0;
        int notTake = 0;
        int var2=0;

        for(int i=nums.length-2;i>=0;i--){
            take = nums[i];
            if(i<nums.length-2){
                take = take + var2;
            }
            
            notTake = var1;
            var2 = notTake;

            var1 =  Math.max(take,notTake);//dp[3]=3//dp[2]=10//dp[1]=10//dp[0]=12
        }

        return var1;

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