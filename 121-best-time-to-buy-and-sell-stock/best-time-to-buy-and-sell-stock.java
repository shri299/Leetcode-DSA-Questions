class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int prev = prices[0];

        for(int i=0;i<prices.length;i++){
            min = Math.min(prev,min);
            max = Math.max(prices[i]-min,max);
            prev = prices[i];
        }

        return max;
    }
}