class Solution {
    public int splitArray(int[] nums, int k) {
        int start = Integer.MIN_VALUE;
        int end = 0;
        for(int val : nums){
            start = Math.max(start,val);
            end = end + val;
        }

        while(start<=end){
            int mid = start + (end-start)/2;
            int count = computeSubArrayCount(nums,mid);
            if(count>k){
                start = mid + 1;
            }else{
                end = mid-1;
            }
        }

        return start;
    }

    private int computeSubArrayCount(int[] nums, int max){
        int subArrayCount = 1;
        int subArraySum = 0;

        for(int val : nums){
            if(subArraySum + val <= max){
                subArraySum = subArraySum + val;
            }else{
                subArrayCount++;
                subArraySum = val;
            }
        }

        return subArrayCount;
    }
}