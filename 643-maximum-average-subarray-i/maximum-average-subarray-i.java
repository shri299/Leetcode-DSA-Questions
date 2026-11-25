class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int i = 0;
        int j = 0;

        while (j < k) {
            sum += nums[j];
            j++;
        }

        double maxAverage = (double) sum / k;

        while (j <= nums.length-1) {
            sum -= nums[i];
            sum += nums[j];
            i++;
            j++;
            maxAverage = Math.max(maxAverage, (double) sum / k);
        }
        return maxAverage;
    }
}