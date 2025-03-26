class Solution {
    public int numEnclaves(int[][] grid) {
         int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean[][] vis = new boolean[n][m];

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || j==0 || i==n-1 || j==m-1) && grid[i][j]==1){ //check for boundry O's
                    dfs(i,j,vis,grid,delRow,delCol);
                }else if(grid[i][j]==0){
                    vis[i][j]=true;
                }
            }
        }

         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]){
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int row, int col, boolean[][] vis, int[][] board, int[] delRow, int[] delCol){
        vis[row][col] = true;
        int n = board.length;
        int m = board[0].length;

        //check in four directions

        for(int i=0;i<4;i++){
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && !vis[newRow][newCol] && board[newRow][newCol]!=0){
                dfs(newRow,newCol,vis,board,delRow,delCol);
            }
        }
    }
}