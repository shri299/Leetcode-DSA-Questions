class Solution {
    public int singleNonDuplicate(int[] nums) {
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