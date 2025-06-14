class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=0, right=0;
        for(int weight:weights){
            left=Math.max(weight, left);
            right+=weight;
        }
        while(left<right){
            int mid=left+(right-left)/2;
            if(canShip(weights, days, mid)){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
         return left;
    }
    private static boolean canShip(int[] weights, int days, int cap){
        int dayCount=1;
        int currentLoad=0;
        for(int w:weights){
            if(currentLoad+w>cap){
                dayCount++;
                currentLoad=w; 
            }else{
                currentLoad+=w;
            }
        }
        return dayCount<=days;
    }
}