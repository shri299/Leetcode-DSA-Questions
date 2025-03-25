class Solution {
    public int[] delI = {-1,0,1,0};
    public int[] delJ = {0,1,0,-1};
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];
        int count = 0;

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    count++;
                    dfs(vis,grid,i,j,rows,cols);
                }
            }
        }
        return count;
    }

    private void dfs(boolean[][] vis, char[][] grid,int row, int col, int rowLen, int colLen){
        vis[row][col]=true;
        for(int i=0;i<4;i++){
            int newRow = row + delI[i];
            int newCol = col + delJ[i];
            if(newRow>=0 && newRow<rowLen && newCol>=0 && newCol<colLen && !vis[newRow][newCol] && grid[newRow][newCol]=='1'){
                dfs(vis,grid,newRow,newCol,rowLen,colLen);
            }
        }
    }
}