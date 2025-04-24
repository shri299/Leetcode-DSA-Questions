class Solution {
    public int minimumDifference(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n= nums.length;
        if(n==1){
            return 0;
        }
        int min_Diff=Integer.MAX_VALUE;
        for(int i=0;i<=n-k;i++){
            int max=nums[i+k-1];  // the last elelemnt of window would be max 
            int min=nums[i];  // first would be min ... in a single window as the array has been sorted
            min_Diff=Math.min(min_Diff,max-min);
     
        
        }
        return min_Diff;
    }
}