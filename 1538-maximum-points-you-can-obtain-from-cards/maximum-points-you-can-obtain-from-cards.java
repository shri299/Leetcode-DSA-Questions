class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int maxSum = 0;
        int sum = 0;

        //get the left sum
        for(int i=0;i<k;i++){
            leftSum = leftSum + cardPoints[i];
        }
        maxSum = leftSum;
        sum  = leftSum;
        int itr = k;
        int len = cardPoints.length;

        while(itr>0){
            len--;
            //reduce last element from starting band
            //add first element of ending band
            sum = sum - cardPoints[itr-1] + cardPoints[len];
            maxSum = Math.max(maxSum,sum);
            itr--;
        }

        return maxSum;
    }
}