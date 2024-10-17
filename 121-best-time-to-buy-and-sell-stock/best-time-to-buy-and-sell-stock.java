class Solution {
    public int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=1;i<prices.length;i++){
            min = Math.min(prices[i-1],min);
            if(min<prices[i]){
                maxProfit = Math.max(maxProfit,prices[i]-min);
            }
        }

        return maxProfit;
    }
}