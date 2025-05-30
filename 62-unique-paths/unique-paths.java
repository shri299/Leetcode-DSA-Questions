class Solution {
    //Memoization
    //TC : mxn
    //SC : dp arr + stack space
    // public int uniquePaths(int m, int n) {
    //     int[][] dp = new int[m][n];
    //     Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
    //     return helper(m-1,n-1,dp);
    // }

    // private int helper(int row, int col, int[][] dp){
    //     if(row==0 && col==0) return 1;
    //     if(row<0 || col<0) return 0;

    //     if(dp[row][col]!=-1) return dp[row][col];
    //     int up = helper(row-1,col,dp);
    //     int left = helper(row,col-1,dp);

    //     return dp[row][col]=up + left;
    // }


    //Tabulation

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(row==0 && col==0){
                    dp[col][row]=1;
                }else{
                    int up = row-1<0 ? 0 : dp[row-1][col];
                    int left = col-1<0 ? 0 : dp[row][col-1];
                    dp[row][col]=up+left;
                }
            }
        }

        return dp[m-1][n-1];
    }
}