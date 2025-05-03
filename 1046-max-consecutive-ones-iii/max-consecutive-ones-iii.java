class Solution {
    // public int longestOnes(int[] nums, int k) {
    //     int left=0;
    //     int right=0;
    //     int zeroCount = 0;
    //     int maxLen = 0;

    //     while(right<nums.length){
    //         if(nums[right]==0){
    //             zeroCount++;
    //         }

    //         if(zeroCount>k){
    //             if(nums[left]==0){
    //                 zeroCount--;
    //             }
    //             left++;
    //         }

    //         if(zeroCount<=k){
    //             int len = right-left+1;
    //             maxLen = Math.max(maxLen,len);
    //         }

    //         right++;
    //     }

    //     return maxLen;
    // }

    //Approach Two

    public int longestOnes(int[] nums, int k) {
        int left=0;
        int right=0;
        int zeroCount = 0;
        int maxLen = 0;

        while(right<nums.length){
            if(nums[right]==0){
                zeroCount++;
            }
            if(zeroCount<=k){
                int len = right-left+1;
                maxLen = Math.max(maxLen,len);
            }
            if(zeroCount>k){ //condition violated, start shrinking
                if(zeroCount>k){
                    if(nums[left]==0){
                        zeroCount--;
                    }
                    left++;
                }
            }
            right++;
        }
        return maxLen;
    }
}