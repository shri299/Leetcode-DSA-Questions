class Solution {

    //Memoization
    //TC:rowxcol
    //SC: dp + stack space
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int[][] dp = new int[triangle.size()][triangle.size()];
    //     Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
    //     return helper(0,0,triangle,dp);
    // }

    // private int helper(int row, int col, List<List<Integer>> triangle,int[][] dp){
    //     if(row==triangle.size()-1) return triangle.get(row).get(col);

    //     if(dp[row][col]!=-1){
    //         return dp[row][col];
    //     }
    //     int down = triangle.get(row).get(col) + helper(row+1,col,triangle,dp);
    //     int diagonal = triangle.get(row).get(col) + helper(row+1,col+1,triangle,dp);

    //     return dp[row][col]=Math.min(down,diagonal);
    // }


    //TC: O(nxn)
    public int minimumTotal(List<List<Integer>> triangle) {
        //start from base and go to top
        int n = triangle.size();
        // int[][] dp = new int[n][n];
        // for(int i=0;i<n;i++){
        //     dp[n-1][i]=triangle.get(n-1).get(i);
        // }

        int[] curr = new int[n];
        for(int i=0;i<n;i++){
            curr[i]=triangle.get(n-1).get(i);
        }

        for(int i = n-2;i>=0;i--){
            int[] prev = new int[n];
            for(int j=i;j>=0;j--){
                int down = triangle.get(i).get(j) + curr[j];
                int diagonal = triangle.get(i).get(j) + curr[j+1];
                prev[j] = Math.min(down,diagonal);
            }
            curr = prev;
        }

        return curr[0];
    }
}