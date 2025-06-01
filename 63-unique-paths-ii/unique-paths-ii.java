class Solution {
    //TC : 2^(m+n)
    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     int m = obstacleGrid.length;
    //     int n = obstacleGrid[0].length;
    //     if(m==1 && n==1){
    //         return obstacleGrid[m-1][n-1]==1 ? 0 : 1;
    //     }
    //     return helper(m-1,n-1,obstacleGrid);
    // }

    // private int helper(int row, int col, int[][] obstacleGrid){
    //     if(row==0 && col==0 && obstacleGrid[row][col]!=1) return 1;
    //     if(row<0 || col<0 || obstacleGrid[row][col]==1) return 0;

    //     int up = helper(row-1,col,obstacleGrid);
    //     int left = helper(row,col-1,obstacleGrid);

    //     return up+left;
    // }

    //TC: mxn
    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     int m = obstacleGrid.length;
    //     int n = obstacleGrid[0].length;
    //     int[][] dp = new int[m][n];
    //     Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
    //     if(m==1 && n==1){
    //         return obstacleGrid[m-1][n-1]==1 ? 0 : 1;
    //     }
    //     return helper(m-1,n-1,obstacleGrid,dp);
    // }

    // private int helper(int row, int col, int[][] obstacleGrid, int[][] dp){
    //     if(row==0 && col==0 && obstacleGrid[row][col]!=1) return 1;
    //     if(row<0 || col<0 || obstacleGrid[row][col]==1) return 0;

    //     if(dp[row][col]!=-1) return dp[row][col];
    //     int up = helper(row-1,col,obstacleGrid,dp);
    //     int left = helper(row,col-1,obstacleGrid,dp);

    //     return dp[row][col] = up+left;
    // }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if(m==1 && n==1){
            return obstacleGrid[m-1][n-1]==1 ? 0 : 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0 && obstacleGrid[i][j]!=1) {
                    dp[i][j] = 1;
                } else {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        int up = i - 1 < 0 ? 0 : dp[i - 1][j];
                        int left = j - 1 < 0 ? 0 : dp[i][j - 1];
                        dp[i][j] = up + left;
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}