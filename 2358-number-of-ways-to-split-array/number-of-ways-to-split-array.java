class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for(int num : nums) {
            sum += num;
        }

        long psum = 0;
        int ans = 0;

        for(int i = 0; i < nums.length - 1; i++) {
            psum += nums[i];
            if(psum >= (sum - psum)) {
                ans++;
            }
        }
        return ans;
    }
}