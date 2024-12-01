class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int max=0;
        boolean prevOne=true;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count = 0;
            }
            else if(nums[i]==1){
                count = count + 1;
                max = Math.max(count,max);
            }
        }

        return max;
    }
}