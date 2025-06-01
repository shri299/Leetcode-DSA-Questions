class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        if(m==1 && n==1){
            return obstacleGrid[m-1][n-1]==1 ? 0 : 1;
        }
        return helper(m-1,n-1,obstacleGrid,dp);
    }

    private int helper(int row, int col, int[][] obstacleGrid, int[][] dp){
        if(row==0 && col==0 && obstacleGrid[row][col]!=1) return 1;
        if(row<0 || col<0 || obstacleGrid[row][col]==1) return 0;

        if(dp[row][col]!=-1) return dp[row][col];
        int up = helper(row-1,col,obstacleGrid,dp);
        int left = helper(row,col-1,obstacleGrid,dp);

        return dp[row][col] = up+left;
    }
}