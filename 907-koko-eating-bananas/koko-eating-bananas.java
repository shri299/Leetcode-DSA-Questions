class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 0;
        int ans = -1;
        int high = Arrays.stream(piles).max().getAsInt();

        while(low<=high){
            int mid = low + (high-low)/2;
            int totalHrs = calcTotalHrsAtRateMid(piles,mid);

            if(totalHrs <= h){
                high = mid-1;
                ans = mid;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public int calcTotalHrsAtRateMid(int[] piles, int rate){
        int totalHrs = 0;
        for (int pile : piles) {
            totalHrs += Math.ceil((double) pile / rate);
        }
        return totalHrs;
    }
}