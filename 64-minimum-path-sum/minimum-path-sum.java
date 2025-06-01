class Solution {
    // public int minPathSum(int[][] grid) {
    //     int n = grid.length;
    //     int m = grid[0].length;
    //     int[][] dp = new int[n][m];
    //     Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
    //     return helper(n-1,m-1,grid,dp);
    // }

    // private int helper(int row, int col, int[][] grid, int[][] dp){
    //     if(row==0 && col==0) return grid[row][col];
    //     if(row<0 || col<0) return (int)1e9;
    //     if(dp[row][col]!=-1) return dp[row][col];
    //     int up = grid[row][col] + helper(row-1,col,grid,dp);
    //     int left = grid[row][col] + helper(row,col-1,grid,dp);

    //     return dp[row][col] = Math.min(up,left);
    // }


    // public int minPathSum(int[][] grid) {
    //     int n = grid.length;
    //     int m = grid[0].length;
    //     int[][] dp = new int[n][m];
        
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //             if(i==0 && j==0){
    //                 dp[i][j]=grid[i][j];
    //             }else{
    //                 if(i-1<0){
    //                     //current row's previous col
    //                     dp[i][j] = grid[i][j] + dp[i][j-1];
    //                 }else if(j-1<0){
    //                     //previous row's current col
    //                     dp[i][j] = grid[i][j] + dp[i-1][j];
    //                 }else{
    //                     dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
    //                 }
    //             }
    //         }
    //     }

    //     return dp[n-1][m-1];
    // }


    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] prev = new int[m];
        
        for(int i=0;i<n;i++){
            int[] current = new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    current[j]=grid[i][j];
                }else{
                    if(i-1<0){
                        //current row's previous col
                        current[j] = grid[i][j] + current[j-1];
                    }else if(j-1<0){
                        //previous row's current col
                        current[j] = grid[i][j] + prev[j];
                    }else{
                        current[j] = grid[i][j] + Math.min(prev[j],current[j-1]);
                    }
                }
            }
            prev = current;
        }

        return prev[m-1];
    }
}