class Solution {
    public int singleNonDuplicate(int[] nums) {
        // for(int i=1;i<nums.length-1;i++){
        //     if(nums[i]!=nums[i+1] && nums[i]!=nums[i-1]){
        //         return nums[i];
        //     }
        // }

        // if(nums.length==1){
        //     return nums[0];
        // }
        // if(nums.length>1){
        //     if(nums[0]!=nums[1]){
        //         return nums[0];
        //     }
        // }

        // return nums[nums.length-1];

        int start = 0;
        int end = nums.length-1;

        if(nums.length==1){
            return nums[0];
        }

        while(start<=end && start<=nums.length-1 && end>=0){
            if(nums[start]!=nums[start+1]){
                return nums[start];
            }else {
                start = start + 2;
            }

            if(nums[end]!=nums[end-1]){
                return nums[end];
            }else {
                end = end - 2;
            }
        }
        return 0;
    }
}