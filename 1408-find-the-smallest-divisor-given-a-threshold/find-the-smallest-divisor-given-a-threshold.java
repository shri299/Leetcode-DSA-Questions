class Solution 
{
    public int fun(int[] nums,int mid)
    {
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            ans+=Math.ceil((double) nums[i]/mid);
        }
        return ans;
    }
    public int smallestDivisor(int[] nums, int threshold) 
    { 
        int l=1;
        int r=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            r=Math.max(r,nums[i]);
            l=Math.min(l,nums[i]);
        }
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            int x=fun(nums,mid);
            if(x<=threshold)
            {
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return l;
    }
}